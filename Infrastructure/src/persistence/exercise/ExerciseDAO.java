package persistence.exercise;

import common.interfaces.DAO;
import entity.Exercise;
import persistence.DataStore;
import persistence.exercise.queries.SelectExerciseQuery;

import java.util.List;

public class ExerciseDAO implements DAO<Exercise> {
    private DataStore<Exercise> dataStore = new DataStore<>();

    @Override
    public long insert(Exercise entity) {
        return 0;
    }

    @Override
    public long update(Exercise entity) {
        return 0;
    }

    @Override
    public long delete(Exercise entity) {
        return 0;
    }

    @Override
    public List<Exercise> query(Exercise entity) {
        return this.dataStore.query(new SelectExerciseQuery(), entity);
    }
}
