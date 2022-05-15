package persistence.exercise;

import common.interfaces.DAO;
import entity.Exercise;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.exercise.queries.SelectExerciseQuery;

import javax.sql.DataSource;
import java.util.List;

public class ExerciseDAO implements DAO<Exercise> {
    private DataStore<Exercise> dataStore = new DataStore<>();
    private DataSource dataSource;

    public ExerciseDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ExerciseDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

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
        return this.dataStore.query(new SelectExerciseQuery(this.dataSource), entity);
    }
}
