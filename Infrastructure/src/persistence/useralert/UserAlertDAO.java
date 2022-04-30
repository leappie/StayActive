package persistence.useralert;


import common.interfaces.DAO;
import entity.User;
import persistence.DataStore;
import persistence.user.commands.DeleteUserCommand;
import persistence.user.commands.InsertUserCommand;
import persistence.user.commands.UpdateUserCommand;
import persistence.useralert.commands.InsertUserAlertCommand;
import persistence.useralert.queries.SelectUserAlertQuery;

import java.util.List;

public class UserAlertDAO implements DAO<User> {
    private DataStore<User> dataStore = new DataStore<>();

    @Override
    public long insert(User entity) {
        return this.dataStore.execute(new InsertUserAlertCommand(), entity);
    }

    @Override
    public long update(User entity) {
        return 0;
    }

    @Override
    public long delete(User entity) {
        return 0;
    }

    @Override
    public List<User> query(User entity) {
        return this.dataStore.query(new SelectUserAlertQuery(), entity);
    }
}
