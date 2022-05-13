package services.intervalexerciselevel;

import entity.Interval;
import entity.User;
import enums.Level;

import java.util.List;

public class ExerciseLevelCreatorB extends ExerciseLevelCreatorA {
    public static final String TAG = "ExerciseLevelCreatorB";

    private User user;

    public ExerciseLevelCreatorB(User user) {
        this.user = user;
    }

    /**
     * This method uses ExerciseLevelCreatorA to get a list of levels. It then updates this list according to the user's
     * experience.
     *
     * @param interval used mainly by ExerciseLevelCreatorA
     * @return Level list
     */
    @Override
    public List<Level> getExerciseDifficulty(Interval interval) {
        Level userLevel = this.user.getLevel();
        List<Level> exerciseLevels = super.getExerciseDifficulty(interval); // call parent class

        if (exerciseLevels.size() > 0) {
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
        }
        return exerciseLevels;
    }

}
