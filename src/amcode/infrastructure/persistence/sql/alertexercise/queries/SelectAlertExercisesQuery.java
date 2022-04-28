package amcode.infrastructure.persistence.sql.alertexercise.queries;

import amcode.application.common.util.LevelConverter;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Exercise;
import amcode.domain.enums.Level;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.common.interfaces.AlertExerciseTable;
import amcode.infrastructure.persistence.sql.common.interfaces.ExerciseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAlertExercisesQuery extends DatabaseQuery<Alert> implements ExerciseTable, AlertExerciseTable {
    private Alert alert;

    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT e.%s, e.%s, e.%s, e.%s, e.%s, e.%s, ae.%s " +
                "FROM %s e " +
                "LEFT JOIN alert_exercise ae " +
                "ON ae.%s = e.%s " +
                "WHERE ae.%s = ? ",
                E_COLUMN_ID, E_COLUMN_NAME, E_COLUMN_REPS, E_COLUMN_SETS, E_COLUMN_TIME, E_COLUMN_LEVEL,
                AE_COLUMN_EXERCISE_WEIGHT, E_TABLE, AE_COLUMN_EXERCISE_ID, E_COLUMN_ID, AE_COLUMN_ALERT_ID);

        return query;
    }

    @Override
    protected PreparedStatement createPreparedStatement(Connection connection, Alert param) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getCommandText());
            this.alert = param;
            preparedStatement.setInt(1, param.getId());

            return preparedStatement;
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
            return null;
        }
    }

    @Override
    protected List<Alert> map(ResultSet resultSet) {
        List<Exercise> exerciseList = new ArrayList<>();
        List<Alert> alertList = new ArrayList<>();

        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(E_COLUMN_ID);
                String name = resultSet.getString(E_COLUMN_NAME);
                int reps = resultSet.getInt(E_COLUMN_REPS);
                int sets = resultSet.getInt(E_COLUMN_SETS);
                int time = resultSet.getInt(E_COLUMN_TIME);
                String levelString = resultSet.getString(E_COLUMN_LEVEL);
                int weight = resultSet.getInt(AE_COLUMN_EXERCISE_WEIGHT);

                Level level = new LevelConverter().tryParse(levelString);
                if (level != null) {
                    Exercise exercise = new Exercise(id, name, reps, sets, time, level, weight);
                    exerciseList.add(exercise);
                }
            }

            this.alert.setExerciseList(exerciseList);
            alertList.add(this.alert);

            return alertList;
        } catch (SQLException e) {
            System.out.println("Error querying user: " + e);
            return null;
        }
    }
}
