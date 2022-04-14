package amcode.model.domain;

import amcode.enums.Level;

import java.util.List;
import java.util.Set;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }
}
