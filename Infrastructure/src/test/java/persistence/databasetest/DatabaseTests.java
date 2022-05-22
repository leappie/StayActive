package persistence.databasetest;

import org.sqlite.SQLiteDataSource;
import persistence.common.Constants;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public abstract class DatabaseTests<T> {
    protected DataSource getDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:src/test/resources/stayactive_testdb.db");
        return dataSource;
    }

    private String getDeleteCommand(String table) {
        return String.format(
                "DELETE FROM %s",
                table);
    }

    protected void initialize() {
        try (Connection connection = getDataSource().getConnection();
             Statement statement = connection.createStatement()){

            statement.addBatch(getDeleteCommand(Constants.UserTable.TABLE));
            statement.addBatch(getDeleteCommand(Constants.AlertTable.TABLE));
            statement.addBatch(getDeleteCommand(Constants.UserExerciseHistoryTable.TABLE));
            statement.addBatch(getDeleteCommand(Constants.ExerciseTable.TABLE));
            statement.addBatch(getDeleteCommand(Constants.AlertExerciseTable.TABLE));

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract String getCommandText();
    protected abstract void setParams(PreparedStatement statement);
    protected abstract List<T> map(ResultSet resultSet);

    public List<T> executeQuery() {
        /*
        The connection, statement and result will be automatically closed inside try
         */
        try (Connection connection = getDataSource().getConnection();
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
