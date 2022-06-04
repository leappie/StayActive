package services;

import common.interfaces.daos.IExerciseDAO;
import entity.Exercise;
import exercise.ExerciseRepository;

import java.util.List;

public class ExerciseService {

    private IExerciseDAO exerciseDAO;

    public ExerciseService(IExerciseDAO exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    public List<Exercise> getAllExercises() {
        ExerciseRepository exerciseRepository = new ExerciseRepository(this.exerciseDAO);
        List<Exercise> exerciseList = exerciseRepository.getAllExercises();

        return exerciseList;
    }
}
