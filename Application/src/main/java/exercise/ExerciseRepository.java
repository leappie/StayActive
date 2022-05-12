package exercise;

import common.interfaces.DAO;
import common.interfaces.Repository;
import entity.Exercise;

import java.util.List;

public class ExerciseRepository implements Repository<Exercise> {
    private DAO<Exercise> exerciseDao;

    public ExerciseRepository(DAO<Exercise> exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    @Override
    public long add(Exercise entity) {
        return this.exerciseDao.insert(entity);
    }

    @Override
    public long update(Exercise entity) {
        return this.exerciseDao.update(entity);
    }

    @Override
    public long remove(Exercise entity) {
        return this.exerciseDao.delete(entity);
    }

    @Override
    public List<Exercise> get(Exercise entity) {
        return this.exerciseDao.query(entity);
    }
}
