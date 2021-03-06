package persistence.alertexercise.commands;

import entity.Alert;
import entity.Exercise;
import persistence.DatabaseCommand;
import persistence.common.Constants.AlertExerciseTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertAlertExerciseCommand extends DatabaseCommand<Alert> {

    public InsertAlertExerciseCommand(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT OR IGNORE INTO %s" +
                "(%s, %s, %s) " +
                "VALUES(?, ?, ?)",
                AlertExerciseTable.TABLE, AlertExerciseTable.COLUMN_ALERT_ID, AlertExerciseTable.COLUMN_EXERCISE_ID,
                AlertExerciseTable.COLUMN_EXERCISE_WEIGHT);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            List<Exercise> exerciseList = data.getExerciseList();

            for (Exercise exercise : exerciseList) {
                preparedStatement.setInt(1, data.getId());
                preparedStatement.setInt(2, exercise.getId());
                preparedStatement.setInt(3, exercise.getWeight());

                preparedStatement.addBatch();
            }

        } catch (SQLException e) {
            System.out.println("Error setting insert statement user alerts: " + e);

        }
    }
}
