package services;

import common.interfaces.DAO;
import entity.Exercise;
import exercise.ExerciseRepository;

import java.util.List;

public class ExerciseService {

    private DAO<Exercise> exerciseDAO;

    public ExerciseService(DAO<Exercise> exerciseDAO) {
        this.exerciseDAO = exerciseDAO;
    }

    public List<Exercise> getAllExercises() {
        ExerciseRepository exerciseRepository = new ExerciseRepository(this.exerciseDAO);
        List<Exercise> exerciseList = exerciseRepository.get(null); // hoeft geen object mee te geven

        return exerciseList;
    }
}
