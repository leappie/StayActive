package exercise;

import common.interfaces.daos.IExerciseDAO;
import common.interfaces.repositories.IExerciseRepository;
import entity.Exercise;

import java.util.List;

public class ExerciseRepository implements IExerciseRepository {
    private IExerciseDAO exerciseDao;

    public ExerciseRepository(IExerciseDAO exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    @Override
    public List<Exercise> getAllExercises() {
        return this.exerciseDao.queryAll();

    }
}
