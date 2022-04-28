package amcode.infrastructure.persistence.sql.useralert.commands;

import amcode.domain.entity.Alert;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.interfaces.AlertTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertUserAlertCommand extends DatabaseCommand<User> implements AlertTable {

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT OR IGNORE INTO %s" +
                        "(%s, %s, %s, %s) " +
                        "VALUES(?, ?, ?, ?)",
                A_TABLE, A_COLUMN_USER_ID, A_COLUMN_NAME, A_COLUMN_START_TIME, A_COLUMN_END_TIME);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, User data) {
        try {
            List<Alert> alertList = data.getAlertList();
            int count = 0;

            for (Alert alert : alertList) {
                preparedStatement.setInt(1, data.getId());
                preparedStatement.setString(2, alert.getName());
                preparedStatement.setString(3, alert.getInterval().getStartTime().toString());
                preparedStatement.setString(4, alert.getInterval().getEndTime().toString());

                preparedStatement.addBatch();
                count++;
            }

            if (count % 100 == 0 || count == alertList.size()) {
                preparedStatement.executeBatch();
            }
        } catch (SQLException e) {
            System.out.println("Error setting insert statement user alerts: " + e);
        }
    }
}