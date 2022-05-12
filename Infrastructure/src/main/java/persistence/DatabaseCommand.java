package persistence;

import java.sql.*;

import static persistence.DataStore.CONNECTION_STRING;

public abstract class DatabaseCommand<T> {
    protected abstract String getCommandText();
    protected abstract void setParams(PreparedStatement preparedStatement, T data);

    public long execute(T data) {
        long id = -1;

         /*
        The connection, statement and result will be automatically closed inside try
         */
        try (Connection connection = DriverManager.getConnection(CONNECTION_STRING);
             PreparedStatement statement = connection.prepareStatement(
                     getCommandText(), Statement.RETURN_GENERATED_KEYS)) {

            setParams(statement, data);
            int affectedRows = statement.executeUpdate();

            /*
            Get the id back
             */
            if (affectedRows > 0) {
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        id = resultSet.getLong(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing command " + e);
        }
        return id;
    }

}
