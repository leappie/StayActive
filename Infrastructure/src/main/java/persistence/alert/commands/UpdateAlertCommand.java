package persistence.alert.commands;

import entity.Alert;
import persistence.DatabaseCommand;
import persistence.common.constants.AlertTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAlertCommand extends DatabaseCommand<Alert> {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                        "SET %s = ?, %s = ? " +
                        "WHERE %s = ?",
                AlertTable.TABLE, AlertTable.COLUMN_START_TIME, AlertTable.COLUMN_END_TIME, AlertTable.COLUMN_ID);
        return query;
    }

    @Override
    protected void setParams(PreparedStatement preparedStatement, Alert data) {
        try {
            preparedStatement.setString(1, data.getInterval().getStartTime().toString());
            preparedStatement.setString(2, data.getInterval().getEndTime().toString());
            preparedStatement.setInt(3, data.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
        }
    }
}
