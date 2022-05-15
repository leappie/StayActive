package persistence.exercise.queries;

import common.util.LevelConverter;
import entity.Exercise;
import enums.Level;
import persistence.DatabaseQuery;
import persistence.common.Constants.ExerciseTable;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectExerciseQuery extends DatabaseQuery<Exercise> {

    public SelectExerciseQuery(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s, %s, %s  " +
                "FROM %s",
                ExerciseTable.COLUMN_ID, ExerciseTable.COLUMN_NAME, ExerciseTable.COLUMN_REPS, ExerciseTable.COLUMN_SETS,
                ExerciseTable.COLUMN_LEVEL, ExerciseTable.COLUMN_TIME, ExerciseTable.TABLE);

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
                int id = resultSet.getInt(ExerciseTable.COLUMN_ID);
                String name = resultSet.getString(ExerciseTable.COLUMN_NAME);
                int reps = resultSet.getInt(ExerciseTable.COLUMN_REPS);
                int sets = resultSet.getInt(ExerciseTable.COLUMN_SETS);
                String levelString = resultSet.getString(ExerciseTable.COLUMN_LEVEL);
                int timeMinutes = resultSet.getInt(ExerciseTable.COLUMN_TIME);

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