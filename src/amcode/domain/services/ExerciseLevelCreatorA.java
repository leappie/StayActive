package amcode.domain.services;

import amcode.domain.enums.Level;
import amcode.domain.interfaces.Exercisable;
import amcode.domain.model.Alert;
import amcode.domain.model.Interval;
import amcode.domain.model.Notification;

import java.util.List;

public class ExerciseLevelCreatorA implements Exercisable {
    @Override
    public Level getExerciseDifficulty(Interval interval) {
        int notificationListSize = interval.getNotificationList().size();
        Notification lastNotification = interval.getNotificationList().get(notificationListSize - 1);
        Level level;

        if (lastNotification == null) {

        }

        return null;
    }

    @Override
    public List<Level> updateExerciseDifficulty(Alert alert, Level level) {
        return null;
    }
}
