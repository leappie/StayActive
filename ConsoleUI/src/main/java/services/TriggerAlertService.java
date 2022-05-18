package services;

import alert.AlertRepository;
import common.interfaces.DAO;
import common.services.CurrentUserService;
import entity.Alert;
import entity.Interval;
import entity.Notification;
import entity.User;
import services.intervalnotification.IntervalNotification;
import services.intervalnotification.NotificationTimeCreatorA;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TriggerAlertService {
    private DAO<Alert> alertExerciseDAO;

    public TriggerAlertService(DAO<Alert> alertExerciseDAO) {
        this.alertExerciseDAO = alertExerciseDAO;
    }

    public LocalTime triggerAlert(Alert alert) {
        // get alert with all exercise + weights paired to alert
        AlertRepository alertRepository = new AlertRepository(this.alertExerciseDAO);
        List<Alert> alertList = alertRepository.get(alert);// -> Note the exercise will be paired to the alert, so same alert
        alert = alertList.get(alertList.size() - 1);

        // calculate notification time
        Interval interval = alert.getInterval();
        IntervalNotification intervalNotification = new IntervalNotification(new NotificationTimeCreatorA());
        LocalTime notificationTime = intervalNotification.calcNextNotificationTime(interval);

        // add notification to interval notificationList
        if (notificationTime != null) {
            // if notificationTime == null, then all notification are triggered OR can't be triggered
            interval.getNotificationList().add(new Notification(notificationTime));
        } else {
            // reset triggers if all notifications are triggered
            interval = resetInterval(interval);
        }
        // update loggedInUser
        updateUserAlert(alert);

        return notificationTime;
    }

    private void updateUserAlert(Alert alert) {
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        for (int i = 0; i < alertList.size(); i ++) {
            Alert checkAlert = alertList.get(i);
            if (checkAlert.getId() == alert.getId()) {
                alertList.set(i, alert);
            }
        }

//        CurrentUserService.setLoggedInUser(loggedInUser);
    }

    private Interval resetInterval(Interval interval) {
        interval.setNotificationsTriggered(0);
        interval.getSubInterval().setStartTime(interval.getStartTime());
        interval.getSubInterval().setEndTime(interval.getEndTime());
        interval.setNotificationList(new ArrayList<>());

        return interval;
    }
}
