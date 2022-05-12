package persistence.alert.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.common.constants.AlertTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAlertCommand extends DatabaseCommand<Alert> {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "DELETE FROM %s " +
                        "WHERE %s = ?",
                AlertTable.TABLE, AlertTable.COLUMN_ID);
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
