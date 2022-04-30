package persistence.exercise.queries;

import common.util.LevelConverter;
import entity.Exercise;
import enums.Level;
import persistence.DatabaseQuery;
import persistence.interfaces.ExerciseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectExerciseQuery extends DatabaseQuery<Exercise> implements ExerciseTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s, %s, %s  " +
                "FROM %s",
                E_COLUMN_ID, E_COLUMN_NAME, E_COLUMN_REPS, E_COLUMN_SETS, E_COLUMN_LEVEL, E_COLUMN_TIME, E_TABLE);

        return query;
    }

    @Override
    protected PreparedStatement createPreparedStatement(Connection connection, Exercise param) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getCommandText());

            return preparedStatement;
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
            return null;
        }
    }

    @Override
    protected List<Exercise> map(ResultSet resultSet) {
        List<Exercise> exerciseList = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(E_COLUMN_ID);
                String name = resultSet.getString(E_COLUMN_NAME);
                int reps = resultSet.getInt(E_COLUMN_REPS);
                int sets = resultSet.getInt(E_COLUMN_SETS);
                String levelString = resultSet.getString(E_COLUMN_LEVEL);
                int timeMinutes = resultSet.getInt(E_COLUMN_TIME);

                Level level = new LevelConverter().tryParse(levelString);
                if (level != null) {
                    Exercise exercise = new Exercise(id, name, reps, sets, timeMinutes, level);
                    exerciseList.add(exercise);
                }
            }
            return exerciseList;
        } catch (SQLException e) {
            System.out.println("Error querying user: " + e);
            return null;
        }
    }
}