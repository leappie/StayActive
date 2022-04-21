package amcode.domain.model;

import amcode.domain.common.Constants;

import java.util.ArrayList;
import java.util.List;

public class Alert {
    private int id;
    private String name;
    private boolean isActive;
    private Interval interval;
    private List<Exercise> exerciseList;

    public Alert(int id, String name, boolean isActive, Interval interval, List<Exercise> exerciseList) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.interval = interval;
        this.exerciseList = exerciseList;
    }

    public Alert(String name, Interval interval) {
        this(Constants.DEFAULT_ID, name, Constants.DEFAULT_IS_ACTIVE, interval, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    @Override
    public String toString() {
        String isActiveString = this.isActive ? "On" : "Off";
        return this.name + " "
                + "(" + interval.getStartTime()
                + "-" + interval.getEndTime()
                + ") " +  isActiveString;
    }

}