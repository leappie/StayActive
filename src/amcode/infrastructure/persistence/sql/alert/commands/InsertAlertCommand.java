package amcode.infrastructure.persistence.sql.alert.commands;

import amcode.domain.entity.Alert;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.interfaces.AlertTable;

import java.sql.PreparedStatement;

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
