package persistence.daotests.user.commands;

import entity.User;
import persistence.DatabaseCommand;
import persistence.common.Constants.UserTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserCommand extends DatabaseCommand<User> {
    public InsertUserCommand(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT OR IGNORE INTO %s" +
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
            preparedStatement.addBatch();

        } catch (SQLException e) {
            System.out.println("Error setting insert statement: " + e);

        }
    }
}
