package persistence.alert.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.interfaces.AlertTable;

import java.sql.PreparedStatement;

// TODO: Not used ..
public class InsertAlertCommand extends DatabaseCommand<Alert> implements AlertTable {

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT OR IGNORE INTO %s" +
                "(%s, %s, %s, %s, %s) " +
                "VALUES(?, ?, ?, ?, ?)",
                A_TABLE, A_COLUMN_ID, A_COLUMN_USER_ID, A_COLUMN_NAME, A_COLUMN_START_TIME, A_COLUMN_END_TIME);
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
