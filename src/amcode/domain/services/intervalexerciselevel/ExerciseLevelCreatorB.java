package amcode.domain.services.intervalexerciselevel;

import amcode.domain.entity.Interval;
import amcode.domain.entity.User;
import amcode.domain.enums.Level;
import amcode.domain.interfaces.Levelable;

import java.util.List;

public class ExerciseLevelCreatorB implements Levelable {
    public static final String TAG = "ExerciseLevelCreatorB";

    private User user;

    public ExerciseLevelCreatorB(User user) {
        this.user = user;
    }

    @Override
    public List<Level> getExerciseDifficulty(Interval interval) {
        Level userLevel = this.user.getLevel();
        List<Level> exerciseLevels = new ExerciseLevelCreatorA().getExerciseDifficulty(interval);
        Level level = exerciseLevels.get(exerciseLevels.size() - 1);

        switch (userLevel) {
            // include more easy exercises
            case EASY:
                if (level == Level.MEDIUM) {
                    exerciseLevels.add(Level.EASY);
                } else if (level == Level.HARD) {
                    exerciseLevels.add(Level.MEDIUM);
                }
                break;
            case MEDIUM:
                // include more difficult exercises
                if (level == Level.EASY) {
                    exerciseLevels.add(Level.MEDIUM);
                } else if (level == Level.MEDIUM) {
                    exerciseLevels.add(Level.HARD);
                }
                break;
            default:
                break;
        }
        return exerciseLevels;
    }

}
