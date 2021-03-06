package entity;

import common.Constants;

import java.util.ArrayList;
import java.util.List;


public class Alert {
    private int id;
    private String name;
    private Interval interval;
    private List<Exercise> exerciseList;

    public Alert(int id, String name, Interval interval, List<Exercise> exerciseList) {
        this.id = id;
        this.name = name;
        this.interval = interval;
        this.exerciseList = exerciseList;
    }

    public Alert(int id, String name, Interval interval) {
        this(id, name, interval, new ArrayList<>());
    }

    public Alert(String name, Interval interval) {
        this(Constants.DEFAULT_ID, name, interval);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Interval getInterval() {
        return interval;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interval=" + interval +
                ", exerciseList=" + exerciseList +
                '}';
    }
}