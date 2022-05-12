package persistence.useralert.queries;

import common.util.LocalTimeConverter;
import entity.Alert;
import entity.Interval;
import entity.User;
import persistence.DatabaseQuery;
import persistence.common.constants.AlertTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class SelectUserAlertQuery extends DatabaseQuery<User> {
    private User user;

    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s " +
                "FROM %s " +
                "WHERE user_id = ?",
                AlertTable.COLUMN_ID, AlertTable.COLUMN_NAME, AlertTable.COLUMN_START_TIME, AlertTable.COLUMN_END_TIME,
                AlertTable.TABLE);

        return query;
    }

    @Override
    protected PreparedStatement createPreparedStatement(Connection connection, User param) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getCommandText());
            this.user = param;
            preparedStatement.setInt(1, param.getId());

            return preparedStatement;
        } catch (SQLException e) {
            System.out.println("Error setting statement: " + e);
            return null;
        }
    }

    @Override
    protected List<User> map(ResultSet resultSet) {
        List<Alert> alertList = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                int id = resultSet.getInt(AlertTable.COLUMN_ID);
                String name = resultSet.getString(AlertTable.COLUMN_NAME);
                String startTimeString = resultSet.getString(AlertTable.COLUMN_START_TIME);
                String endTimeString = resultSet.getString(AlertTable.COLUMN_END_TIME);

                LocalTimeConverter localTimeConverter = new LocalTimeConverter();
                LocalTime startTime = localTimeConverter.tryParse(startTimeString);
                LocalTime endTime = localTimeConverter.tryParse(endTimeString);

                if (startTime != null && endTime != null) {
                    Alert alert = new Alert(id, name, new Interval(startTime, endTime));
                    alertList.add(alert);
                }
            }
            this.user.setAlertList(alertList);
            userList.add(this.user);

            return userList;
        } catch (SQLException e) {
            System.out.println("Error querying user: " + e);
            return null;
        }
    }
}