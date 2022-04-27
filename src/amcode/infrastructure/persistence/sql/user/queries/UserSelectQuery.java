package amcode.infrastructure.persistence.sql.user.queries;

import amcode.application.common.util.LevelConverter;
import amcode.domain.entity.User;
import amcode.domain.enums.Level;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.user.interfaces.UserTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelectQuery extends DatabaseQuery<User> implements UserTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s " +
                "FROM %s " +
                "WHERE username = ? AND password = ?",
                COLUMN_ID, COLUMN_USERNAME, COLUMN_PASSWORD, COLUMN_LEVEL, TABLE);

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
                int id = resultSet.getInt(COLUMN_ID);
                String username = resultSet.getString(COLUMN_USERNAME);
                String password = resultSet.getString(COLUMN_PASSWORD);
                String levelString = resultSet.getString(COLUMN_LEVEL);

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
