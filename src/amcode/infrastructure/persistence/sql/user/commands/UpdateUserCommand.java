package amcode.infrastructure.persistence.sql.user.commands;

import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.interfaces.UserTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserCommand extends DatabaseCommand<User> implements UserTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                "SET %s = ?, %s = ?, %s = ? " +
                "WHERE %s = ?",
                U_TABLE, U_COLUMN_USERNAME, U_COLUMN_PASSWORD, U_COLUMN_LEVEL, U_COLUMN_ID);
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