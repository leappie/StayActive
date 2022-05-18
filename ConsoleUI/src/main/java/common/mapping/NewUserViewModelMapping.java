package common.mapping;

import common.interfaces.Mapping;
import entity.User;
import enums.Level;
import model.NewUserViewModel;

public class NewUserViewModelMapping implements Mapping<NewUserViewModel, User> {

    @Override
    public User mapToEntity(NewUserViewModel viewModel) {
        String username = viewModel.getUsername();
        String password = viewModel.getPassword();
        String levelString = viewModel.getLevel();
        Level level = convertToLevel(levelString);

        return new User(username, password, level);
    }

    @Override
    public NewUserViewModel mapToModel(User entity) {
        return new NewUserViewModel(entity.getUsername(), entity.getPassword(), entity.getLevel().toString());
    }

    private Level convertToLevel(String word) {
        Level level = null;
        if (word.equalsIgnoreCase("e")) {
            level = Level.EASY;
        } else if (word.equalsIgnoreCase("m")) {
            level =Level.MEDIUM;
        }
        return level;
    }
}