package persistence;

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
     *
     * @param statement
     * @return
     */
    protected abstract void setParams(PreparedStatement statement);

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

    public List<T> execute() {
        /*
        The connection, statement and result will be automatically closed inside try
         */
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(getCommandText())) {
            setParams(statement);

            try(ResultSet resultSet = statement.executeQuery()) {
                return map(resultSet);

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}