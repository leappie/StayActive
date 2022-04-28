package amcode.application.exercise;

import amcode.application.common.interfaces.daos.IExerciseDao;
import amcode.application.common.interfaces.repositories.IExerciseRepository;
import amcode.domain.entity.Exercise;

import java.util.List;

public class ExerciseRepository implements IExerciseRepository {
    private IExerciseDao exerciseDao;

    public ExerciseRepository(IExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    @Override
    public void addExercise(Exercise exercise) {
        this.exerciseDao.insertExercise(exercise);
    }

    @Override
    public void updateExercise(Exercise exercise) {
        this.exerciseDao.updateExercise(exercise);
    }

    @Override
    public void removeExercise(Exercise exercise) {
        this.exerciseDao.deleteExercise(exercise);
    }

    @Override
    public List<Exercise> getAllExercises(Exercise exercise) {
        return this.exerciseDao.getAllExercises(exercise);
    }
}
