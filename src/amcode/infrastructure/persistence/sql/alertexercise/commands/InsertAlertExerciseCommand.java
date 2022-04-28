package amcode.infrastructure.persistence.sql.alertexercise.commands;

import amcode.domain.entity.Alert;
import amcode.domain.entity.Exercise;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.common.interfaces.AlertExerciseTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertAlertExerciseCommand extends DatabaseCommand<Alert> implements AlertExerciseTable {

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT OR IGNORE INTO %s" +
                "(%s, %s, %s) " +
                "VALUES(?, ?, ?)",
                AE_TABLE, AE_COLUMN_ALERT_ID, AE_COLUMN_EXERCISE_ID, AE_COLUMN_EXERCISE_WEIGHT);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            List<Exercise> exerciseList = data.getExerciseList();
            int count = 0;

            for (Exercise exercise : exerciseList) {
                preparedStatement.setInt(1, data.getId());
                preparedStatement.setInt(2, exercise.getId());
                preparedStatement.setInt(3, exercise.getWeight());

                preparedStatement.addBatch();
                count++;
            }

            if (count % 100 == 0 || count == exerciseList.size()) {
                preparedStatement.executeBatch();
            }
        } catch (SQLException e) {
            System.out.println("Error setting insert statement user alerts: " + e);

        }
    }
}
