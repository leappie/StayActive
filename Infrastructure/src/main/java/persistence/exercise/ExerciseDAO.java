package persistence.exercise;

import common.interfaces.daos.IExerciseDAO;
import entity.Exercise;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.exercise.queries.SelectExerciseQuery;

import javax.sql.DataSource;
import java.util.List;

public class ExerciseDAO implements IExerciseDAO {
    private DataStore<Exercise> dataStore = new DataStore<>();
    private DataSource dataSource;

    public ExerciseDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ExerciseDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public List<Exercise> queryAll() {
        return this.dataStore.query(new SelectExerciseQuery(this.dataSource));
    }
}
