package model;

import java.util.ArrayList;
import java.util.List;

public class UserMainViewModel {
    private String username;
    private String level;
    private List<AlertViewModel> alertViewModelList;
    private List<ExerciseHistoryViewModel> exerciseHistoryViewModels;

    public UserMainViewModel(String username, String level,
                             List<AlertViewModel> alertViewModelList,
                             List<ExerciseHistoryViewModel> exerciseHistoryViewModels) {
        this.username = username;
        this.level = level;
        this.alertViewModelList = alertViewModelList;
        this.exerciseHistoryViewModels = exerciseHistoryViewModels;
    }

    public UserMainViewModel() {
        this("", "", new ArrayList<>(), new ArrayList<>());
    }

    public String getUsername() {
        return username;
    }

    public String getLevel() {
        return level;
    }

    public List<AlertViewModel> getAlertViewModelList() {
        return alertViewModelList;
    }

    public List<ExerciseHistoryViewModel> getExerciseHistoryViewModels() {
        return exerciseHistoryViewModels;
    }
}
