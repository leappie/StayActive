package amcode.infrastructure.persistence.sql.user;

import amcode.application.common.interfaces.daos.IUserDao;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.user.commands.DeleteUserCommand;
import amcode.infrastructure.persistence.sql.user.commands.InsertUserCommand;
import amcode.infrastructure.persistence.sql.user.commands.UpdateUserCommand;
import amcode.infrastructure.persistence.sql.user.queries.SelectUserAlertsQuery;
import amcode.infrastructure.persistence.sql.user.queries.SelectUserQuery;

import java.util.HashMap;
import java.util.List;

public class UserDao implements IUserDao {
    private HashMap<String, DatabaseQuery<User>> userDatabaseQueryList;
    private HashMap<String, DatabaseCommand<User>> userDatabaseCommandList;

    public UserDao(HashMap<String, DatabaseQuery<User>> userDatabaseQueryList,
                   HashMap<String, DatabaseCommand<User>> userDatabaseCommandList) {
        this.userDatabaseQueryList = userDatabaseQueryList;
        this.userDatabaseCommandList = userDatabaseCommandList;
    }

    public UserDao() {
        /*
        For convenience
         */
        this.userDatabaseQueryList = new HashMap<>();
        this.userDatabaseQueryList.put("getUser", new SelectUserQuery());
        this.userDatabaseQueryList.put("getUserAlerts", new SelectUserAlertsQuery());

        this.userDatabaseCommandList = new HashMap<>();
        this.userDatabaseCommandList.put("insert", new InsertUserCommand());
        this.userDatabaseCommandList.put("update", new UpdateUserCommand());
        this.userDatabaseCommandList.put("delete", new DeleteUserCommand());
    }

    @Override
    public long insertUser(User user) {
        DatabaseCommand<User> databaseCommand = this.userDatabaseCommandList.get("insert");
        return databaseCommand.execute(user);
    }

    @Override
    public long updateUser(User user) {
        DatabaseCommand<User> databaseCommand = this.userDatabaseCommandList.get("update");
        return databaseCommand.execute(user);
    }

    @Override
    public long deleteUser(User user) {
        DatabaseCommand<User> databaseCommand = this.userDatabaseCommandList.get("delete");
        return databaseCommand.execute(user);
    }

    @Override
    public User getUser(User user) {
        List<User> userList = this.userDatabaseQueryList.get("getUser").execute(user);
        User foundUser;
        /*
        The username is unique so this will always return one user
         */

        if (userList.size() > 0) {
            foundUser = userList.get(userList.size() - 1);
        } else {
            foundUser = null;
        }
        return foundUser;
    }

    @Override
    public User getUserAlerts(User user) {
        List<User> userList = this.userDatabaseQueryList.get("getUserAlerts").execute(user);
        User foundUser;

        if (userList.size() > 0) {
            foundUser = userList.get(userList.size() - 1);
        } else {
            /*
            if list is empty, no alerts found return current user
             */
            foundUser = user;
        }

        return foundUser;
    }

}
