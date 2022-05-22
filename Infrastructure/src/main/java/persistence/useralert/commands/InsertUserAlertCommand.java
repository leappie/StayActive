package persistence.useralert.commands;

import entity.Alert;
import entity.User;
import persistence.DatabaseCommand;
import persistence.common.Constants.AlertTable;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class InsertUserAlertCommand extends DatabaseCommand<User> {

    public InsertUserAlertCommand(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String getCommandText() {
        String query = String.format(
                "INSERT INTO OR IGNORE %s" +
                        "(%s, %s, %s, %s) " +
                        "VALUES(?, ?, ?, ?)",
                AlertTable.TABLE, AlertTable.COLUMN_USER_ID, AlertTable.COLUMN_NAME, AlertTable.COLUMN_START_TIME,
                AlertTable.COLUMN_END_TIME);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, User data) {
        try {
            List<Alert> alertList = data.getAlertList();

            // insert only last item
            Alert alert = alertList.get(alertList.size() - 1);

            preparedStatement.setInt(1, data.getId());
            preparedStatement.setString(2, alert.getName());
            preparedStatement.setString(3, alert.getInterval().getStartTime().toString());
            preparedStatement.setString(4, alert.getInterval().getEndTime().toString());
            preparedStatement.addBatch();
        } catch (SQLException e) {
            System.out.println("Error setting insert statement user alerts: " + e);
        }
    }
}
