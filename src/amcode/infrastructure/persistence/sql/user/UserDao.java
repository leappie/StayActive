package amcode.infrastructure.persistence.sql.user;

import amcode.application.common.interfaces.daos.IUserDao;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.user.commands.UserDeleteCommand;
import amcode.infrastructure.persistence.sql.user.commands.UserInsertCommand;
import amcode.infrastructure.persistence.sql.user.commands.UserUpdateCommand;
import amcode.infrastructure.persistence.sql.user.queries.UserSelectQuery;

import java.util.HashMap;
import java.util.List;

public class UserDao implements IUserDao {
    private DatabaseQuery<User> userDatabaseQuery;
    private HashMap<String, DatabaseCommand<User>> userDatabaseCommandList;

    public UserDao(DatabaseQuery<User> userDatabaseQuery, HashMap<String, DatabaseCommand<User>> userDatabaseCommandList) {
        this.userDatabaseQuery = userDatabaseQuery;
        this.userDatabaseCommandList = userDatabaseCommandList;
    }

    public UserDao() {
        /*
        For convenience
         */
        this.userDatabaseQuery = new UserSelectQuery();
        this.userDatabaseCommandList = new HashMap<>();
        this.userDatabaseCommandList.put("insert", new UserInsertCommand());
        this.userDatabaseCommandList.put("update", new UserUpdateCommand());
        this.userDatabaseCommandList.put("delete", new UserDeleteCommand());
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
        List<User> userList = this.userDatabaseQuery.execute(user);
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
}
