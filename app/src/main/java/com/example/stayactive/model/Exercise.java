package com.example.stayactive.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(
        tableName = "exercise")
public class Exercise {
    @PrimaryKey
    private int exerciseId;

    private String name;
    private double kCalPerHour;
    private int reps; // how many reps an exercise will have: 50 squats
    private Date duration; // how long the exercise will take: e.g. 1 min push-ups
    private int difficultyLevel; // there are 3 levels of difficulty 1 = easy, 2 = medium, 3 = hard

    @Ignore
    private static final int DEFAULT_ID = 0;

    public Exercise(int exerciseId, String name, double kCalPerHour, int reps, Date duration, int difficultyLevel) {
        this.exerciseId = exerciseId;
        this.name = name;
        this.kCalPerHour = kCalPerHour;
        this.reps = reps;
        this.duration = duration;
        this.difficultyLevel = difficultyLevel;
    }

    public Exercise(String name, double kCalPerHour, int reps, Date duration, int difficultyLevel) {
        this(DEFAULT_ID, name, kCalPerHour, reps, duration, difficultyLevel);
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public String getName() {
        return name;
    }

    public double getKCalPerHour() {
        return kCalPerHour;
    }

    public int getReps() {
        return reps;
    }

    public Date getDuration() {
        return duration;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

}
