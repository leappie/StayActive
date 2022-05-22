package persistence.daotests.user;


import common.interfaces.daos.IUserDAO;
import entity.User;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.daotests.user.commands.DeleteUserCommand;
import persistence.daotests.user.commands.InsertUserCommand;
import persistence.daotests.user.commands.UpdateUserCommand;
import persistence.daotests.user.queries.SelectUserQuery;

import javax.sql.DataSource;
import java.util.List;

public class UserDAO implements IUserDAO {
    private DataStore<User> dataStore = new DataStore<>();
    private DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(User user) {
        return this.dataStore.execute(new InsertUserCommand(this.dataSource), user);
    }

    @Override
    public long update(User user) {
        return this.dataStore.execute(new UpdateUserCommand(this.dataSource), user);
    }

    @Override
    public void delete(User user) {
        this.dataStore.execute(new DeleteUserCommand(this.dataSource), user);
    }

    @Override
    public List<User> query(User user) {
        return this.dataStore.query(new SelectUserQuery(this.dataSource, user));
    }


}
