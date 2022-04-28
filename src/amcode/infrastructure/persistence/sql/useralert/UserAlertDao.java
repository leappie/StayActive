package amcode.infrastructure.persistence.sql.useralert;

import amcode.application.common.interfaces.daos.IUserAlertDao;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.alert.queries.SelectUserAlertQuery;
import amcode.infrastructure.persistence.sql.useralert.commands.InsertUserAlertCommand;

import java.util.HashMap;
import java.util.List;

public class UserAlertDao implements IUserAlertDao {
    private HashMap<String, DatabaseQuery<User>> userAlertQueryList;
    private HashMap<String, DatabaseCommand<User>> userAlertCommandList;

    public UserAlertDao(HashMap<String, DatabaseQuery<User>> userAlertQueryList,
                        HashMap<String, DatabaseCommand<User>> userAlertCommandList) {
        this.userAlertQueryList = userAlertQueryList;
        this.userAlertCommandList = userAlertCommandList;
    }

    public UserAlertDao() {
        this.userAlertQueryList = new HashMap<>();
        this.userAlertCommandList = new HashMap<>();

        this.userAlertCommandList.put("insert", new InsertUserAlertCommand());
        this.userAlertQueryList.put("getUserAlerts", new SelectUserAlertQuery());
    }

    @Override
    public long insertUserAlert(User user) {
        return this.userAlertCommandList.get("insert").execute(user);
    }

    @Override
    public long updateUseAlert(User user) {
        return 0;
    }

    @Override
    public long deleteUserAlert(User user) {
        return 0;
    }

    @Override
    public User getUserAlerts(User user) {
        List<User> userList = this.userAlertQueryList.get("insert").execute(user);

        return userList.get(userList.size() - 1);
    }
}
