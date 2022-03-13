package com.example.stayactive.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "data")
public class Data {
    @PrimaryKey
    private int dataId;

    private Date exerciseDate;
    private double kCaloriesBurned;
    private Date exerciseTime;
    private int nrOfTimesDone; // how many times you have done the exercise on that day.

    @Ignore
    private static final int DEFAULT_ID = 0;

    public Data(int dataId, Date exerciseDate, double kCaloriesBurned, Date exerciseTime, int nrOfTimesDone) {
        this.dataId = dataId;
        this.exerciseDate = exerciseDate;
        this.kCaloriesBurned = kCaloriesBurned;
        this.exerciseTime = exerciseTime;
        this.nrOfTimesDone = nrOfTimesDone;
    }

    public Data(Date exerciseDate, double kCaloriesBurned, Date exerciseTime, int nrOfTimesDone) {
        this(DEFAULT_ID, exerciseDate, kCaloriesBurned, exerciseTime, nrOfTimesDone);
    }

    public int getDataId() {
        return dataId;
    }

    public Date getExerciseDate() {
        return exerciseDate;
    }

    public double getKCaloriesBurned() {
        return kCaloriesBurned;
    }

    public Date getExerciseTime() {
        return exerciseTime;
    }

    public int getNrOfTimesDone() {
        return nrOfTimesDone;
    }

    public void setNrOfTimesDone(int nrOfTimesDone) {
        this.nrOfTimesDone = nrOfTimesDone;
    }



}
