package common.mapping;

import common.interfaces.Mapping;
import common.util.LevelConverter;
import entity.Exercise;
import enums.Level;
import model.ExerciseViewModel;

public class OnExerciseViewMapping implements Mapping<ExerciseViewModel, Exercise> {
    @Override
    public Exercise mapTo(ExerciseViewModel viewModel) {
        Level level = new LevelConverter().tryParse(viewModel.getLevel());

        if (level != null) {
            return new Exercise(viewModel.getExerciseName(), viewModel.getReps(), viewModel.getSets(),
                    viewModel.getExerciseTime(), level);
        }
        return null;
    }

    @Override
    public ExerciseViewModel mapFrom(Exercise entity) {
        return new ExerciseViewModel(entity.getName(), entity.getReps(), entity.getSets(),
                entity.getExerciseTimeMinutes(), entity.getLevel().toString());
    }
}
