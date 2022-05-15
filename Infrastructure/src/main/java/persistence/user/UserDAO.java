package persistence.user;


import common.interfaces.DAO;
import entity.User;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.user.commands.DeleteUserCommand;
import persistence.user.commands.InsertUserCommand;
import persistence.user.commands.UpdateUserCommand;
import persistence.user.queries.SelectUserQuery;

import javax.sql.DataSource;
import java.util.List;

public class UserDAO implements DAO<User> {
    private DataStore<User> dataStore = new DataStore<>();
    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(User entity) {
        return this.dataStore.execute(new InsertUserCommand(this.dataSource), entity);
    }

    @Override
    public long update(User entity) {
        return this.dataStore.execute(new UpdateUserCommand(this.dataSource), entity);
    }

    @Override
    public long delete(User entity) {
        return this.dataStore.execute(new DeleteUserCommand(this.dataSource), entity);
    }

    @Override
    public List<User> query(User entity) {
        return this.dataStore.query(new SelectUserQuery(this.dataSource), entity);
    }
}
