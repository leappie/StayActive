package amcode.infrastructure.persistence.sql.alert.commands;

import amcode.domain.entity.Alert;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.common.interfaces.AlertTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateAlertCommand extends DatabaseCommand<Alert> implements AlertTable {
    @Override
    protected String getCommandText() {
        String query = String.format(
                "UPDATE %s " +
                "SET %s = ?, %s = ? " +
                "WHERE %s = ?",
                A_TABLE, A_COLUMN_START_TIME, A_COLUMN_END_TIME, A_COLUMN_ID);
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
            System.out.println("Error setting update statement: " + e);
        }
    }
}
