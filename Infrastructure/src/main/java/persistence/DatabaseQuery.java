package persistence;

import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Template pattern used to for querying db.
 * @param <T>
 */
public abstract class DatabaseQuery<T> {
    /**
     * Get SQL query text set by child class
     * @return
     */
    protected abstract String getCommandText();

    /**
     * Prepare statement
     * @param connection
     * @param param can be null, example -> select all
     * @return
     */
    protected abstract PreparedStatement createPreparedStatement(Connection connection, T param);

    /**
     * Returns a list of items.
     * @param resultSet
     * @return
     */
    protected abstract List<T> map(ResultSet resultSet);

    private final DataSource dataSource;

    public DatabaseQuery(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<T> execute(T param) {
        /*
        The connection, statement and result will be automatically closed inside try
         */
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = createPreparedStatement(connection, param);
             ResultSet resultSet = statement.executeQuery()) {

            return map(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}