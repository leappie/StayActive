package amcode.consolui.common.mapping;

import amcode.application.common.interfaces.Mapping;
import amcode.consolui.model.UserLoginViewModel;
import amcode.domain.entity.User;


public class UserLoginMapping implements Mapping<UserLoginViewModel, User> {

    @Override
    public User mapTo(UserLoginViewModel viewModel) {
        return new User(viewModel.getUsername(), viewModel.getPassword());
    }

    @Override
    public UserLoginViewModel mapFrom(User entity) {
        return new UserLoginViewModel(entity.getUsername(), entity.getPassword());
    }
}
