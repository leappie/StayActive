package persistence.user.commands;

import entity.User;
import persistence.DatabaseCommand;
import persistence.common.constants.UserTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserCommand extends DatabaseCommand<User> {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT INTO %s" +
                "(%s, %s, %s) " +
                "VALUES(?, ?, ?)",
                UserTable.TABLE, UserTable.COLUMN_USERNAME, UserTable.COLUMN_PASSWORD, UserTable.COLUMN_LEVEL);
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
