package services;

import alert.AlertRepository;
import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.Alert;
import entity.Exercise;
import entity.User;
import user.UserRepository;

import java.util.List;

public class NewAlertService {

    private DAO<User> userAlertDAO;
    private DAO<Alert> alertExerciseDAO;

    public NewAlertService(DAO<User> userAlertDAO, DAO<Alert> alertExerciseDAO) {
        this.userAlertDAO = userAlertDAO;
        this.alertExerciseDAO = alertExerciseDAO;
    }

    public void AddNewAlert(User loggedInUser, List<Exercise> exerciseList) {
        // add alert to db
        UserRepository userRepository = new UserRepository(this.userAlertDAO);
        userRepository.add(loggedInUser);

        // get back updated user
        List<User> userList = userRepository.get(loggedInUser);
        User user = userList.get(userList.size() - 1);

        // Update loggedInUser
        CurrentUserService.setLoggedInUser(user);

        // get last alert (id needed)
        int size = loggedInUser.getAlertList().size();
        Alert checkAlert = loggedInUser.getAlertList().get(size - 1);

        // pair exercises to alert
        checkAlert.setExerciseList(exerciseList);

        // add to alert_exercise table -> pairing exercise weight to alert in db
        AlertRepository alertRepository = new AlertRepository(this.alertExerciseDAO);
        alertRepository.add(checkAlert);
    }

}
