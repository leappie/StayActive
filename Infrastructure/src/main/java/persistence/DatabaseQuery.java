package persistence;

import persistence.common.constants.Constants;

import java.sql.*;
import java.util.List;

public abstract class DatabaseQuery<T> {
    protected abstract String getCommandText();

    protected abstract PreparedStatement createPreparedStatement(Connection connection, T param);

    protected abstract List<T> map(ResultSet resultSet);

    public List<T> execute(T param) {
        /*
        The connection, statement and result will be automatically closed inside try
         */
        try (Connection connection = DriverManager.getConnection(Constants.CONNECTION_STRING);
             PreparedStatement statement = createPreparedStatement(connection, param);
             ResultSet resultSet = statement.executeQuery()) {

            return map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
