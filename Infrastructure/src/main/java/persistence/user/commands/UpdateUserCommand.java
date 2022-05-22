package persistence.user.commands;

import entity.User;
import persistence.DatabaseCommand;
import persistence.common.Constants.UserTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserCommand extends DatabaseCommand<User> {
    public UpdateUserCommand(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                "SET %s = ?, %s = ?, %s = ? " +
                "WHERE %s = ?",
                UserTable.TABLE, UserTable.COLUMN_USERNAME, UserTable.COLUMN_PASSWORD, UserTable.COLUMN_LEVEL,
                UserTable.COLUMN_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, User data) {
        try {
            preparedStatement.setString(1, data.getUsername());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.setString(3, data.getLevel().toString());
            preparedStatement.setInt(4, data.getId());
            preparedStatement.addBatch();

        } catch (SQLException e) {
            System.out.println("Error setting update statement: " + e);

        }
    }
}