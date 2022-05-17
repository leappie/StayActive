package common.mapping;


import common.interfaces.Mapping;
import entity.User;
import model.UserLoginViewModel;

public class UserLoginViewMapping implements Mapping<UserLoginViewModel, User> {

    @Override
    public User mapToEntity(UserLoginViewModel viewModel) {
        return new User(viewModel.getUsername(), viewModel.getPassword());
    }

    @Override
    public UserLoginViewModel mapToModel(User entity) {
        return new UserLoginViewModel(entity.getUsername(), entity.getPassword());
    }
}
