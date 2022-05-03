package persistence.alert.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.interfaces.AlertTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAlertCommand extends DatabaseCommand<Alert> implements AlertTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "DELETE FROM %s " +
                        "WHERE %s = ?",
                A_TABLE, A_COLUMN_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            preparedStatement.setInt(1, data.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
        }
    }
}
