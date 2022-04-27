package amcode.application.user;

import amcode.application.common.interfaces.daos.IUserDao;
import amcode.application.common.interfaces.repositories.IUserRepository;
import amcode.domain.entity.User;

public class UserRepository implements IUserRepository {
    private IUserDao userDao;

    public UserRepository(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public long addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public long updateUser(User user) {
       return userDao.updateUser(user);
    }

    @Override
    public long removeUser(User user) {
        return userDao.deleteUser(user);

    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }
}
