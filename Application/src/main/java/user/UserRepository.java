package user;

import common.interfaces.daos.IUserDAO;
import common.interfaces.repositories.IUserRepository;
import entity.User;

import java.util.List;

public class UserRepository implements IUserRepository {
    private IUserDAO userDao;

    public UserRepository(IUserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    public long addUser(User user) {
        return this.userDao.insert(user);
    }

    @Override
    public long updateUser(User user) {
        return this.userDao.update(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userDao.delete(user);
    }

    @Override
    public User getUser(User user) {
        User getUser = null;
        List<User> userList = this.userDao.query(user);

        // Username and id is unique. This will always return 1 item
        if (userList.size() != 0) {
            getUser = userList.get(userList.size() - 1);
        }

        return getUser;
    }


}
