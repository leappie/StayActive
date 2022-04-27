package amcode.infrastructure.persistence.sql.user.commands;

import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.user.interfaces.UserTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserInsertCommand extends DatabaseCommand<User> implements UserTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT INTO %s" +
                "(%s, %s, %s) " +
                "VALUES(?, ?, ?)",
                TABLE, COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_LEVEL);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, User data) {
        try {
            preparedStatement.setString(1, data.getUsername());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.setString(3, data.getLevel().toString());

        } catch (SQLException e) {
            System.out.println("Error setting insert statement: " + e);

        }
    }
}
