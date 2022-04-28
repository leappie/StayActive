package amcode.infrastructure.persistence.sql.exercise;

import amcode.application.common.interfaces.daos.IExerciseDao;
import amcode.domain.entity.Exercise;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.exercise.queries.SelectExerciseQuery;

import java.util.HashMap;
import java.util.List;

public class ExerciseDao implements IExerciseDao {
    private HashMap<String, DatabaseQuery<Exercise>> databaseQueryList;
    private HashMap<String, DatabaseCommand<Exercise>> databaseCommandList;

    public ExerciseDao(HashMap<String, DatabaseQuery<Exercise>> databaseQueryList,
                       HashMap<String, DatabaseCommand<Exercise>> databaseCommandList) {
        this.databaseQueryList = databaseQueryList;
        this.databaseCommandList = databaseCommandList;
    }

    public ExerciseDao() {
        /*
        for convenience
         */
        this.databaseQueryList = new HashMap<>();
        this.databaseQueryList.put("getExercises", new SelectExerciseQuery());

        this.databaseCommandList = new HashMap<>();
    }

    @Override
    public long insertExercise(Exercise exercise) {
        return 0;
    }

    @Override
    public long updateExercise(Exercise exercise) {
        return 0;
    }

    @Override
    public long deleteExercise(Exercise exercise) {
        return 0;
    }

    @Override
    public List<Exercise> getAllExercises(Exercise exercise) {
        return this.databaseQueryList.get("getExercises").execute(exercise);
    }
}
