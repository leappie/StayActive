package services;

import entity.Interval;
import entity.Notification;
import entity.User;
import enums.Level;
import services.intervalexerciselevel.ExerciseLevelCreatorA;
import services.intervalexerciselevel.ExerciseLevelCreatorB;
import services.intervalexerciselevel.IntervalExerciseLevel;

import java.util.List;

public class ExerciseLevelService {

    public List<Level> getExerciseLevel(Interval interval) {
        List<Level> levelList;

        // get last added notification
        int size = interval.getNotificationList().size();
        Notification notification = interval.getNotificationList().get(size - 1);

        // set notification to accepted
        notification.setAccepted(true);

        levelList = new IntervalExerciseLevel(new ExerciseLevelCreatorA()).
                    getExerciseDifficulty(interval);

        return levelList;
    }

    public List<Level> getExerciseLevel(Interval interval, User user) {
        List<Level> levelList;

        // get last added notification
        int size = interval.getNotificationList().size();
        Notification notification = interval.getNotificationList().get(size - 1);

        // set notification to accepted
        notification.setAccepted(true);

        // get exercise level
        levelList = new IntervalExerciseLevel(new ExerciseLevelCreatorB(user)).
                getExerciseDifficulty(interval);

        return levelList;
    }
}
