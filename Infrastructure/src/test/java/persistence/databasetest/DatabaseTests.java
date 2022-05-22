package persistence.databasetest;

import org.sqlite.SQLiteDataSource;
import persistence.common.Constants;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTests {
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


}
