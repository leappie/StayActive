package amcode.domain.entity;

import amcode.domain.enums.Level;

import java.time.LocalTime;

public class Exercise {
    private int id;
    private String name;
    private int reps;
    private int sets;
    private LocalTime exerciseTime;
    private Level level;
    private int weight;

    public Exercise(int id, String name, int reps, int sets, LocalTime exerciseTime, Level level, int weight) {
        this.id = id;
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.exerciseTime = exerciseTime;
        this.level = level;
        this.weight = weight;
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

    public LocalTime getExerciseTime() {
        return exerciseTime;
    }

    public Level getLevel() {
        return level;
    }

    public int getWeight() {
        return weight;
    }

    public void updateWeight() {
        if (this.weight < 5) {
            this.weight = 10; // reset weight
        } else {
            this.weight--;
        }
    }


}