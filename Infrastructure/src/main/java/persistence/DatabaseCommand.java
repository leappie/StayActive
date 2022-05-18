package persistence;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Template pattern for db commands.
 * @param <T>
 */
public abstract class DatabaseCommand<T> {
    /**
     * Command text example: Insert ...
     * @return
     */
    protected abstract String getCommandText();

    /**
     * Creates statement
     * @param preparedStatement
     * @param data
     */
    protected abstract void setParams(PreparedStatement preparedStatement, T data);

    private final DataSource dataSource;

    public DatabaseCommand(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public long execute(T data) {
        long id = -1;

         /*
        The connection, statement and result will be automatically closed inside try
         */
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     getCommandText(), Statement.RETURN_GENERATED_KEYS)) {

            setParams(statement, data);
            int[] affectedRows = statement.executeBatch();

            /*
            Get the id back
             */
            if (affectedRows.length > 0) {
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
