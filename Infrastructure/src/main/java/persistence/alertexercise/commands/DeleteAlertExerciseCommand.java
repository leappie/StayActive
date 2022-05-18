package persistence.alertexercise.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.common.Constants.AlertExerciseTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAlertExerciseCommand extends DatabaseCommand<Alert> {

    public DeleteAlertExerciseCommand(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "DELETE FROM %s " +
                "WHERE %s = ?",
                AlertExerciseTable.TABLE, AlertExerciseTable.COLUMN_ALERT_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            preparedStatement.setInt(1, data.getId());
            preparedStatement.addBatch();
        } catch (SQLException e) {
            System.out.println("Error setting update statement: " + e);
        }
    }
}