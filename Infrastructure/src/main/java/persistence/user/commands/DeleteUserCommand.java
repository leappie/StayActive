package persistence.user.commands;

import entity.User;
import persistence.DatabaseCommand;
import persistence.common.Constants.UserTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserCommand extends DatabaseCommand<User> {
    public DeleteUserCommand(DataSource dataSource) {
        super(dataSource);
    }

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