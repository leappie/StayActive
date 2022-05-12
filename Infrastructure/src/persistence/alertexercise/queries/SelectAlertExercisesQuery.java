package persistence.alertexercise.queries;

import common.util.LevelConverter;
import entity.Alert;
import entity.Exercise;
import enums.Level;
import persistence.DatabaseQuery;
import persistence.common.constants.AlertExerciseTable;
import persistence.common.constants.ExerciseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAlertExercisesQuery extends DatabaseQuery<Alert> {
    private Alert alert;

    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT e.%s, e.%s, e.%s, e.%s, e.%s, e.%s, ae.%s " +
                "FROM %s e " +
                "LEFT JOIN alert_exercise ae " +
                "ON ae.%s = e.%s " +
                "WHERE ae.%s = ? ",
                ExerciseTable.COLUMN_ID, ExerciseTable.COLUMN_NAME, ExerciseTable.COLUMN_REPS, ExerciseTable.COLUMN_SETS,
                ExerciseTable.COLUMN_TIME, ExerciseTable.COLUMN_LEVEL, AlertExerciseTable.COLUMN_EXERCISE_WEIGHT,
                ExerciseTable.TABLE, AlertExerciseTable.COLUMN_EXERCISE_ID, ExerciseTable.COLUMN_ID,
                AlertExerciseTable.COLUMN_ALERT_ID);

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
                int id = resultSet.getInt(ExerciseTable.COLUMN_ID);
                String name = resultSet.getString(ExerciseTable.COLUMN_NAME);
                int reps = resultSet.getInt(ExerciseTable.COLUMN_REPS);
                int sets = resultSet.getInt(ExerciseTable.COLUMN_SETS);
                int time = resultSet.getInt(ExerciseTable.COLUMN_TIME);
                String levelString = resultSet.getString(ExerciseTable.COLUMN_LEVEL);
                int weight = resultSet.getInt(AlertExerciseTable.COLUMN_EXERCISE_WEIGHT);

                Level level = new LevelConverter().tryParse(levelString);
                if (level != null) {
                    Exercise exercise = new Exercise(id, name, reps, sets, time, level, weight);
                    exerciseList.add(exercise);
                }
            }
            this.alert.setExerciseList(exerciseList);
            alertList.add(this.alert); // returns one item in the list
            return alertList;
        } catch (SQLException e) {
            System.out.println("Error querying user: " + e);
            return null;
        }
    }
}
