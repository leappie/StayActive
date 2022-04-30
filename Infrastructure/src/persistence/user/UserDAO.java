package persistence.user;


import common.interfaces.DAO;
import entity.User;
import persistence.DataStore;
import persistence.user.commands.DeleteUserCommand;
import persistence.user.commands.InsertUserCommand;
import persistence.user.commands.UpdateUserCommand;
import persistence.user.queries.SelectUserQuery;

import java.util.List;

public class UserDAO implements DAO<User> {
    private DataStore<User> dataStore = new DataStore<>();

    @Override
    public long insert(User entity) {
        return this.dataStore.execute(new InsertUserCommand(), entity);
    }

    @Override
    public long update(User entity) {
        return this.dataStore.execute(new UpdateUserCommand(), entity);
    }

    @Override
    public long delete(User entity) {
        return this.dataStore.execute(new DeleteUserCommand(), entity);
    }

    @Override
    public List<User> query(User entity) {
        return this.dataStore.query(new SelectUserQuery(), entity);
    }
}
