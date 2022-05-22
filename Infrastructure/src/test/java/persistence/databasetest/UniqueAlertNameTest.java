package persistence.databasetest;

import entity.Alert;
import entity.Interval;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import persistence.common.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UniqueAlertNameTest extends DatabaseTests<Alert> {

    @Override
    protected String getCommandText() {
        return String.format(
                "SELECT %s, %s, %s, %s " +
                        "FROM %s",
                Constants.AlertTable.COLUMN_ID, Constants.AlertTable.COLUMN_NAME, Constants.AlertTable.COLUMN_START_TIME,
                Constants.AlertTable.COLUMN_END_TIME, Constants.AlertTable.TABLE);
    }

    @Override
    protected void setParams(PreparedStatement statement) {}

    @Override
    protected List<Alert> map(ResultSet resultSet) {
        List<Alert> alertList = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(Constants.AlertTable.COLUMN_ID);
                String name = resultSet.getString(Constants.AlertTable.COLUMN_NAME);
                String startTimeStr = resultSet.getString(Constants.AlertTable.COLUMN_START_TIME);
                String endTimeStr = resultSet.getString(Constants.AlertTable.COLUMN_END_TIME);

                LocalTime startTime = LocalTime.parse(startTimeStr);
                LocalTime endTime = LocalTime.parse(endTimeStr);
                if (startTime != null && endTime != null) {
                    Alert alert = new Alert(id, name, new Interval(startTime, endTime));
                    alertList.add(alert);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alertList;
    }

    /*
    user_id and alert name combination is unique
     */
    @Test
    public void testUniqueKeyAlertName() {
        initialize();
        final String commandText = String.format(
                "INSERT OR IGNORE INTO %s" +
                        "(%s, %s, %s, %s, %s) " +
                        "VALUES(?, ?, ?, ?, ?)",
                Constants.AlertTable.TABLE, Constants.AlertTable.COLUMN_ID, Constants.AlertTable.COLUMN_USER_ID,
                Constants.AlertTable.COLUMN_NAME, Constants.AlertTable.COLUMN_START_TIME,
                Constants.AlertTable.COLUMN_END_TIME);
        final Alert alert = new Alert(1, "Alert 1", new Interval(LocalTime.of(8, 0),
                LocalTime.of(12, 0)));
        final int USER_ID = 1;

        try (Connection connection = getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(commandText)) {

            // Insert same alert twice
            for (int i = 1; i <= 2; i++) {
                statement.setInt(1, i);
                statement.setInt(2, 1);
                statement.setString(3, alert.getName());
                statement.setString(4, alert.getInterval().getStartTime().toString());
                statement.setString(5, alert.getInterval().getEndTime().toString());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println("Error executing command " + e);
        }

        Assertions.assertEquals(1, executeQuery().size());

    }
}
