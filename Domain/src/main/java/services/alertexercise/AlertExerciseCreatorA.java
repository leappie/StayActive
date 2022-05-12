package services.alertexercise;


import entity.Alert;
import entity.Exercise;
import enums.Level;
import interfaces.Exercisable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AlertExerciseCreatorA implements Exercisable {
    @Override
    public Exercise getExerciseOnNotification(Alert alert, List<Level> levelList) {
        List<Exercise> exerciseList = alert.getExerciseList();
        List<Exercise> toDoExercises = new ArrayList<>();

        /*
         * For each level in the list of levels check the exercise with the same level.
         * Add this found exercise to the list of toDoExercises. The amount of adds to the list will
         * depend on the exercise weight.
         */
        for (Level level: levelList) {
            for (Exercise exercise: exerciseList) {
                if (exercise.getLevel() == level) {
                    for (int i = 1; i <= exercise.getWeight(); i++)
                        toDoExercises.add(exercise);
                }
            }
        }

        // Get a random exercise from the list and update its weight.
        Collections.shuffle(toDoExercises);
        Random random = new Random();
        final int listSize = toDoExercises.size();
        final int listMin = 0;
        final int listMax = listSize - 1;
        final int randomIndex = listMin + random.nextInt(listMax - listMin + 1);
        Exercise exercise = toDoExercises.get(randomIndex);

        // update exercise weight
        if (exercise != null) {
            exercise.updateWeight();
        }
        return exercise;
    }

}
