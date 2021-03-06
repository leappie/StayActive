package persistence.alertexercise.commands;

import entity.Alert;
import entity.Exercise;
import persistence.DatabaseCommand;
import persistence.common.Constants.AlertExerciseTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateAlertExerciseCommand extends DatabaseCommand<Alert> {

    public UpdateAlertExerciseCommand(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                        "SET %s = ? " +
                        "WHERE %s = ? AND %s = ? ",
                AlertExerciseTable.TABLE, AlertExerciseTable.COLUMN_EXERCISE_WEIGHT, AlertExerciseTable.COLUMN_ALERT_ID,
                AlertExerciseTable.COLUMN_EXERCISE_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            List<Exercise> exerciseList = data.getExerciseList();

            for (Exercise exercise : exerciseList) {
                preparedStatement.setInt(1, exercise.getWeight());
                preparedStatement.setInt(2, data.getId());
                preparedStatement.setInt(3, exercise.getId());

                preparedStatement.addBatch();
            }

        } catch (SQLException e) {
            System.out.println("Error setting update statement: " + e);
        }
    }
}