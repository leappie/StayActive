package amcode.domain.services.alertexercise;

import amcode.domain.entity.Alert;
import amcode.domain.enums.Level;
import amcode.domain.interfaces.Exercisable;
import amcode.domain.entity.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AlertExerciseCreatorA implements Exercisable {
    @Override
    public Exercise getExerciseOnNotification(Alert alert, List<Level> levelList) {
        List<Exercise> exerciseList = alert.getExerciseList();
        List<Exercise> toDoExercises = new ArrayList<>();

        for (Level level: levelList) {
            for (Exercise exercise: exerciseList) {
                if (exercise.getLevel() == level) {
                    for (int i = 1; i <= exercise.getWeight(); i++)
                        toDoExercises.add(exercise);
                }
            }
        }

        Collections.shuffle(toDoExercises);
        Random random = new Random();
        final int listSize = toDoExercises.size();
        final int listMin = 0;
        final int listMax = listSize - 1;
        final int randomIndex = listMin + random.nextInt(listMax - listMin + 1);
        Exercise exercise = toDoExercises.get(randomIndex);

        if (exercise != null) {
            exercise.updateWeight();
        }

        return exercise;
    }

}
