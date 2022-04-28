package amcode.infrastructure.persistence.sql.alert.queries;

import amcode.application.common.util.LocalTimeConverter;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Interval;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.interfaces.AlertTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class SelectUserAlertQuery extends DatabaseQuery<User> implements AlertTable {
    private User user;

    @Override
    protected String getCommandText() {
        String query = String.format(
                "SELECT %s, %s, %s, %s " +
                "FROM %s " +
                "WHERE user_id = ?",
                A_COLUMN_ID, A_COLUMN_NAME, A_COLUMN_START_TIME, A_COLUMN_END_TIME, A_TABLE);

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
                int id = resultSet.getInt(A_COLUMN_ID);
                String name = resultSet.getString(A_COLUMN_NAME);
                String startTimeString = resultSet.getString(A_COLUMN_START_TIME);
                String endTimeString = resultSet.getString(A_COLUMN_END_TIME);

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