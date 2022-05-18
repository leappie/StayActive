package services;

import alert.AlertRepository;
import alertexercise.AlertExerciseRepository;
import common.interfaces.DAO;
import common.interfaces.daos.IAlertExerciseDAO;
import common.interfaces.daos.IUserAlertDAO;
import common.interfaces.repositories.IAlertExerciseRepository;
import common.interfaces.repositories.IUserAlertRepository;
import common.services.CurrentUserService;
import entity.Alert;
import entity.Exercise;
import entity.User;
import user.UserRepository;
import useralert.UserAlertRepository;

import java.util.List;

public class NewAlertService {

    private IUserAlertDAO userAlertDAO;
    private IAlertExerciseDAO alertExerciseDAO;

    public NewAlertService(IUserAlertDAO userAlertDAO, IAlertExerciseDAO alertExerciseDAO) {
        this.userAlertDAO = userAlertDAO;
        this.alertExerciseDAO = alertExerciseDAO;
    }

    public void addNewAlert(User loggedInUser, List<Exercise> exerciseList) {
        // add alert to db
        IUserAlertRepository userAlertRepository = new UserAlertRepository(this.userAlertDAO);
        userAlertRepository.insertUserAlert(loggedInUser);

        // get back updated user
        User user = userAlertRepository.queryUserAlert(loggedInUser);

        // Update loggedInUser
        CurrentUserService.setLoggedInUser(user);

        // get last alert (id needed)
        int size = loggedInUser.getAlertList().size();
        Alert checkAlert = loggedInUser.getAlertList().get(size - 1);

        // pair exercises to alert
        checkAlert.setExerciseList(exerciseList);

        // add to alert_exercise table -> pairing exercise weight to alert in db
        IAlertExerciseRepository alertExerciseRepository = new AlertExerciseRepository(this.alertExerciseDAO);
        alertExerciseRepository.insertAlertExercise(checkAlert);
    }

}
