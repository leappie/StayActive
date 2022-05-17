package persistence.useralert;


import common.interfaces.DAO;
import entity.User;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.useralert.commands.InsertUserAlertCommand;
import persistence.useralert.queries.SelectUserAlertQuery;

import javax.sql.DataSource;
import java.util.List;

public class UserAlertDAO implements DAO<User> {
    private DataStore<User> dataStore = new DataStore<>();
    private DataSource dataSource;

    public UserAlertDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public UserAlertDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(User entity) {
        return this.dataStore.execute(new InsertUserAlertCommand(this.dataSource), entity);
    }

    @Override
    public long update(User entity) {
        // TODO
        return 0;
    }

    @Override
    public long delete(User entity) {
        // TODO
        return 0;
    }

    @Override
    public List<User> query(User entity) {
        return this.dataStore.query(new SelectUserAlertQuery(this.dataSource), entity);
    }
}
