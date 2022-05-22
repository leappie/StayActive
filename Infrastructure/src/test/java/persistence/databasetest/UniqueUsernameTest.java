package persistence.databasetest;

import common.util.LevelConverter;
import entity.User;
import enums.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import persistence.common.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UniqueUsernameTest extends DatabaseTests<User> {

    @Override
    protected String getCommandText() {
        return String.format(
                "SELECT %s, %s, %s, %s " +
                        "FROM %s",
                Constants.UserTable.COLUMN_ID, Constants.UserTable.COLUMN_USERNAME, Constants.UserTable.COLUMN_PASSWORD,
                Constants.UserTable.COLUMN_LEVEL,
                Constants.UserTable.TABLE);
    }

    @Override
    protected void setParams(PreparedStatement statement) {}

    @Override
    protected List<User> map(ResultSet resultSet) {
        List<User> userList = new ArrayList<>();
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(Constants.UserTable.COLUMN_ID);
                String username = resultSet.getString(Constants.UserTable.COLUMN_USERNAME);
                String password = resultSet.getString(Constants.UserTable.COLUMN_PASSWORD);
                String levelString = resultSet.getString(Constants.UserTable.COLUMN_LEVEL);

                Level level = new LevelConverter().tryParse(levelString);
                if (level != null) {
                    User user = new User(id, username, password, level);
                    userList.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Test
    public void testUniqueKeyUsername() {
        initialize();
        final String commandText = String.format(
                "INSERT OR IGNORE INTO %s" +
                        "(%s, %s, %s) " +
                        "VALUES(?, ?, ?)",
                Constants.UserTable.TABLE, Constants.UserTable.COLUMN_USERNAME, Constants.UserTable.COLUMN_PASSWORD,
                Constants.UserTable.COLUMN_LEVEL);
        final User user = new User("test1", "1234", Level.MEDIUM);

        try (Connection connection = getDataSource().getConnection();
             PreparedStatement statement = connection.prepareStatement(commandText)) {

            // Insert same username twice
            for (int i = 1; i <= 2; i++) {
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getLevel().toString());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println("Error executing command " + e);
        }

        Assertions.assertEquals(1, executeQuery().size());
    }

}
