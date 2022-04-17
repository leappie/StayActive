package amcode.model.domain;


import amcode.model.services.util.Level;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private Level level;
    private List<Alert> alertList;
    private List<Exercise> exerciseList;

    public User(int id, String username, String password, Level level, List<Alert> alertList,
                List<Exercise> exerciseList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
        this.alertList = alertList;
        this.exerciseList = exerciseList;
    }

    public User(String username, String password, List<Alert> alertList, List<Exercise> exerciseList) {
        this(0, username, password, null, alertList, exerciseList);
    }


    public User(String username, String password) {
        this(username, password, new ArrayList<>(), new ArrayList<>());
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Level getLevel() {
        return level;
    }

    public List<Alert> getAlertList() {
        return alertList;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }
}
