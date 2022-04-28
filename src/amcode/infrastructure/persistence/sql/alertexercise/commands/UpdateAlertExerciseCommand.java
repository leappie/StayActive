package amcode.infrastructure.persistence.sql.alertexercise.commands;

import amcode.domain.entity.Alert;
import amcode.domain.entity.Exercise;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.common.interfaces.AlertExerciseTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateAlertExerciseCommand extends DatabaseCommand<Alert> implements AlertExerciseTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                        "SET %s = ? " +
                        "WHERE %s = ? AND %s = ? ",
                AE_TABLE, AE_COLUMN_EXERCISE_WEIGHT, AE_COLUMN_ALERT_ID, AE_COLUMN_EXERCISE_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            List<Exercise> exerciseList = data.getExerciseList();
            int count = 0;

            for (Exercise exercise : exerciseList) {
                preparedStatement.setInt(1, exercise.getWeight());
                preparedStatement.setInt(2, data.getId());
                preparedStatement.setInt(3, exercise.getId());

                preparedStatement.addBatch();
                count++;
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            System.out.println("Error setting update statement: " + e);
        }
    }
}