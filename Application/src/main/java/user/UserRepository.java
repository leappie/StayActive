package user;

import common.interfaces.DAO;
import common.interfaces.Repository;
import entity.User;

import java.util.List;

public class UserRepository implements Repository<User> {
    private DAO<User> userDao;

    public UserRepository(DAO<User> userDao) {
        this.userDao = userDao;
    }

    @Override
    public long add(User entity) {
        return this.userDao.insert(entity);
    }

    @Override
    public long update(User entity) {
        return this.userDao.update(entity);
    }

    @Override
    public long remove(User entity) {
        return userDao.delete(entity);
    }

    @Override
    public List<User> get(User entity) {
        return this.userDao.query(entity);
    }
}
