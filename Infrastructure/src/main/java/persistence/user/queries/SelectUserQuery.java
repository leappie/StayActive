package persistence.user.queries;


import common.util.LevelConverter;
import entity.User;
import enums.Level;
import persistence.DatabaseQuery;
import persistence.common.constants.UserTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectUserQuery extends DatabaseQuery<User> {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s " +
                "FROM %s " +
                "WHERE username = ? AND password = ?",
                UserTable.COLUMN_ID, UserTable.COLUMN_USERNAME, UserTable.COLUMN_PASSWORD, UserTable.COLUMN_LEVEL,
                UserTable.TABLE);

        return query;
    }

    @Override
    protected PreparedStatement createPreparedStatement(Connection connection, User param) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getCommandText());
            preparedStatement.setString(1, param.getUsername());
            preparedStatement.setString(2, param.getPassword());

            return preparedStatement;
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
            return null;
        }
    }

    @Override
    protected List<User> map(ResultSet resultSet) {
        List<User> usersList = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(UserTable.COLUMN_ID);
                String username = resultSet.getString(UserTable.COLUMN_USERNAME);
                String password = resultSet.getString(UserTable.COLUMN_PASSWORD);
                String levelString = resultSet.getString(UserTable.COLUMN_LEVEL);

                Level level = new LevelConverter().tryParse(levelString);
                if (level != null) {
                    User user = new User(id, username, password, level);
                    usersList.add(user);
                }
            }
            return usersList;
        } catch (SQLException e) {
            System.out.println("Error querying user: " + e);
            return null;
        }
    }
}
