package amcode.infrastructure.persistence.sql.user.commands;

import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.user.interfaces.UserTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateCommand extends DatabaseCommand<User> implements UserTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                "SET %s = ?, %s = ?, %s = ? " +
                "WHERE %s = ?",
                TABLE, COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_LEVEL, COLUMN_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, User data) {
        try {
            preparedStatement.setString(1, data.getUsername());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.setString(3, data.getLevel().toString());
            preparedStatement.setInt(4, data.getId());

        } catch (SQLException e) {
            System.out.println("Error setting update statement: " + e);

        }
    }
}