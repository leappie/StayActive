package amcode.domain.entity;

import amcode.domain.enums.Level;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    private int id;
    private String name;
    private int reps;
    private int sets;
    private int exerciseTimeMinutes;
    private Level level;
    private int weight;
    private List<ExerciseHistory> exerciseHistoryList;

    public Exercise(int id, String name, int reps, int sets, int exerciseTimeMinutes, Level level,
                    int weight, List<ExerciseHistory> exerciseHistoryList) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.exerciseTimeMinutes = exerciseTimeMinutes;
        this.level = level;
        this.weight = weight;
        this.exerciseHistoryList = exerciseHistoryList;
    }

    public Exercise(int id, String name, int reps, int sets, int exerciseTimeMinutes, Level level, int weight) {
        this(id, name, reps, sets, exerciseTimeMinutes, level, weight, new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getExerciseTimeMinutes() {
        return exerciseTimeMinutes;
    }

    public Level getLevel() {
        return level;
    }

    public int getWeight() {
        return weight;
    }

    public List<ExerciseHistory> getExerciseHistoryList() {
        return exerciseHistoryList;
    }

    public void updateWeight() {
        if (this.weight < 5) {
            this.weight = 10; // reset weight
        } else {
            this.weight--;
        }
    }


}