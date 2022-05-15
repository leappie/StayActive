package persistence.alert.queries;


import common.util.LocalTimeConverter;
import entity.Alert;
import entity.Interval;
import entity.User;
import org.sqlite.SQLiteDataSource;
import persistence.DatabaseQuery;
import persistence.common.Constants.AlertTable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



public class SelectAlertQuery extends DatabaseQuery<Alert> {
    private User user;

    public SelectAlertQuery(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s " +
                        "FROM %s",
                AlertTable.COLUMN_ID, AlertTable.COLUMN_NAME, AlertTable.COLUMN_START_TIME,
                AlertTable.COLUMN_END_TIME, AlertTable.TABLE);

        return query;
    }

    @Override
    protected PreparedStatement createPreparedStatement(Connection connection, Alert param) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getCommandText());

            return preparedStatement;
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
            return null;
        }
    }

    @Override
    protected List<Alert> map(ResultSet resultSet) {
        List<Alert> alertList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(AlertTable.COLUMN_ID);
                String name = resultSet.getString(AlertTable.COLUMN_NAME);
                String startTimeString = resultSet.getString(AlertTable.COLUMN_START_TIME);
                String endTimeString = resultSet.getString(AlertTable.COLUMN_END_TIME);

                LocalTimeConverter localTimeConverter = new LocalTimeConverter();
                LocalTime startTime = localTimeConverter.tryParse(startTimeString);
                LocalTime endTime = localTimeConverter.tryParse(endTimeString);

                if (startTime != null && endTime != null) {
                    Alert alert = new Alert(id, name, new Interval(startTime, endTime));
                    alertList.add(alert);
                }
            }

            return alertList;
        } catch (SQLException e) {
            System.out.println("Error querying user: " + e);
            return null;
        }
    }
}