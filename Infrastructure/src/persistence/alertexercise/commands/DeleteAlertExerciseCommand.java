package persistence.alertexercise.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.interfaces.AlertExerciseTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAlertExerciseCommand extends DatabaseCommand<Alert> implements AlertExerciseTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "DELETE FROM %s " +
                "WHERE %s = ?",
                AE_TABLE, AE_COLUMN_ALERT_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            preparedStatement.setInt(1, data.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error setting update statement: " + e);
        }
    }
}