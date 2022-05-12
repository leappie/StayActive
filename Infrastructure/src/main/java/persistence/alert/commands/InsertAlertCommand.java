package persistence.alert.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.common.constants.AlertTable;

import java.sql.PreparedStatement;

// TODO: Not used ..
public class InsertAlertCommand extends DatabaseCommand<Alert> {

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT OR IGNORE INTO %s" +
                "(%s, %s, %s, %s, %s) " +
                "VALUES(?, ?, ?, ?, ?)",
                AlertTable.TABLE, AlertTable.COLUMN_ID, AlertTable.COLUMN_USER_ID, AlertTable.COLUMN_NAME,
                AlertTable.COLUMN_START_TIME, AlertTable.COLUMN_END_TIME);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
//        try {
//
//        } catch (SQLException e) {
//            System.out.println("Error setting insert statement user alerts: " + e);
//
//        }
    }
}
