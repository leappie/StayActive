//package amcode.infrastructure.persistence.sql.useralert.queries;
//
//import amcode.application.common.dtos.UserAlertsDTO;
//import amcode.application.common.util.LocalTimeConverter;
//import amcode.domain.entity.Alert;
//import amcode.domain.entity.Interval;
//import amcode.domain.entity.User;
//import amcode.infrastructure.persistence.sql.DatabaseQuery;
//import amcode.infrastructure.persistence.sql.interfaces.AlertTable;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SelectUserAlertsQuery extends DatabaseQuery<UserAlertsDTO> implements AlertTable {
//    private User user;
//
//    @Override
//    protected String getCommandText() {
//        String query = String.format(
//                "SELECT %s, %s, %s, %s " +
//                "FROM %s " +
//                "WHERE user_id = ?",
//                COLUMN_ID, COLUMN_NAME, COLUMN_START_TIME, COLUMN_END_TIME, TABLE);
//
//        return query;
//    }
//
//    @Override
//    protected PreparedStatement createPreparedStatement(Connection connection, UserAlertsDTO param) {
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(getCommandText());
//            this.user = param.getUser();
//            preparedStatement.setInt(1, user.getId());
//
//            return preparedStatement;
//        } catch (SQLException e) {
//            System.out.println("Error setting statement user alerts: " + e);
//            return null;
//        }
//    }
//
//    @Override
//    protected List<UserAlertsDTO> map(ResultSet resultSet) {
//        List<UserAlertsDTO> userAlertsDTOList = new ArrayList<>();
//        List<Alert> alertList = new ArrayList<>();
//        try {
//            while(resultSet.next()) {
//                int id = resultSet.getInt(COLUMN_ID);
//                String name = resultSet.getString(COLUMN_NAME);
//                String startTimeString = resultSet.getString(COLUMN_START_TIME);
//                String endTimeString = resultSet.getString(COLUMN_END_TIME);
//
//                LocalTimeConverter localTimeConverter = new LocalTimeConverter();
//                LocalTime startTime = localTimeConverter.tryParse(startTimeString);
//                LocalTime endTime = localTimeConverter.tryParse(endTimeString);
//
//                if (startTime != null && endTime != null) {
//                    Alert alert = new Alert(id, name, new Interval(startTime, endTime));
//                    alertList.add(alert);
//                }
//            }
//            userAlertsDTOList.add(new UserAlertsDTO(this.user, alertList));
//            return userAlertsDTOList;
//        } catch (SQLException e) {
//            System.out.println("Error querying user alerts: " + e);
//            return null;
//        }
//    }
//}
