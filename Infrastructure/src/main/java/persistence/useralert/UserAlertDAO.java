package persistence.useralert;


import common.interfaces.DAO;
import common.interfaces.daos.IUserAlertDAO;
import entity.User;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.useralert.commands.InsertUserAlertCommand;
import persistence.useralert.queries.SelectUserAlertQuery;

import javax.sql.DataSource;
import java.util.List;

public class UserAlertDAO implements IUserAlertDAO {
    private DataStore<User> dataStore = new DataStore<>();
    private DataSource dataSource;

    public UserAlertDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserAlertDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(User user) {
        return this.dataStore.execute(new InsertUserAlertCommand(this.dataSource), user);
    }

    @Override
    public List<User> query(User user) {
        return this.dataStore.query(new SelectUserAlertQuery(this.dataSource, user));
    }
}
