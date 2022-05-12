package persistence.user.commands;

import entity.User;
import persistence.DatabaseCommand;
import persistence.common.constants.UserTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserCommand extends DatabaseCommand<User> {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "DELETE FROM %s " +
                "WHERE %s = ?",
                UserTable.TABLE, UserTable.COLUMN_USERNAME);
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