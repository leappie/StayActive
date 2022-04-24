package amcode.domain.entity;

import amcode.domain.enums.Level;
import amcode.domain.common.Constants;

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


    public User(String username, String password, Level level) {
        this(Constants.DEFAULT_ID,username, password, level, new ArrayList<>(), new ArrayList<>());
    }

    public User(String username, String password) {
        this(username, password, Constants.DEFAULT_LEVEL);
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
