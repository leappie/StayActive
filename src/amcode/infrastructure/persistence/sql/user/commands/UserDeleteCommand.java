package amcode.infrastructure.persistence.sql.user.commands;

import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.user.interfaces.UserTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteCommand extends DatabaseCommand<User> implements UserTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "DELETE FROM %s " +
                "WHERE %s = ?",
                TABLE, COLUMN_USERNAME);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, User data) {
        try {
            preparedStatement.setString(1, data.getUsername());

        } catch (SQLException e) {
            System.out.println("Error setting delete statement: " + e);

        }
    }
}