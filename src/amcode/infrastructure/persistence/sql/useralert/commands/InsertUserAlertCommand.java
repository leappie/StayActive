package amcode.infrastructure.persistence.sql.useralert.commands;

import amcode.domain.entity.Alert;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.common.interfaces.AlertTable;

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

            // insert only last item
            Alert alert = alertList.get(alertList.size() - 1);

            preparedStatement.setInt(1, data.getId());
            preparedStatement.setString(2, alert.getName());
            preparedStatement.setString(3, alert.getInterval().getStartTime().toString());
            preparedStatement.setString(4, alert.getInterval().getEndTime().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error setting insert statement user alerts: " + e);
        }
    }
}



//        try {
//                List<Alert> alertList = data.getAlertList();
//        int count = 0;
//        boolean customBreak = false; // insert only last item
//
//        for (Alert alert : alertList) {
//        if (count == 1) {
//        customBreak = true;
//        break;
//        }
//        preparedStatement.setInt(1, data.getId());
//        preparedStatement.setString(2, alert.getName());
//        preparedStatement.setString(3, alert.getInterval().getStartTime().toString());
//        preparedStatement.setString(4, alert.getInterval().getEndTime().toString());
//
//        preparedStatement.addBatch();
//        count++;
//        }
//
//        if (count % 100 == 0 || count == alertList.size() || customBreak) {
//        preparedStatement.executeBatch();
//        }
//        } catch (SQLException e) {
//        System.out.println("Error setting insert statement user alerts: " + e);
//        }