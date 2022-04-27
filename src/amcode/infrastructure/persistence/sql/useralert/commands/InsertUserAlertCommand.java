//package amcode.infrastructure.persistence.sql.useralert.commands;
//
//import amcode.application.common.dtos.UserAlertsDTO;
//import amcode.domain.entity.Alert;
//import amcode.domain.entity.User;
//import amcode.infrastructure.persistence.sql.DatabaseCommand;
//import amcode.infrastructure.persistence.sql.interfaces.AlertTable;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//public class InsertUserAlertCommand extends DatabaseCommand<UserAlertsDTO> implements AlertTable {
//
//    @Override
//    protected String getCommandText() {
//        String query = String.format(
//                "INSERT INTO %s" +
//                "(%s, %s, %s, %s) " +
//                "VALUES(?, ?, ?, ?)",
//                TABLE, COLUMN_USER_ID, COLUMN_NAME, COLUMN_START_TIME, COLUMN_END_TIME);
//        return query;
//    }
//
//    @Override
//    protected void setParams(PreparedStatement preparedStatement, UserAlertsDTO data) {
//        try {
//            User user = data.getUser();
//            List<Alert> alertList = data.getAlertList();
//            int count = 0;
//
//            /*
//            Can update 1 or multiple alerts at once.
//             */
//            for (Alert alert : alertList) {
//                preparedStatement.setInt(1, user.getId());
//                preparedStatement.setString(2, alert.getName());
//                preparedStatement.setString(3, alert.getInterval().getStartTime().toString());
//                preparedStatement.setString(4, alert.getInterval().getEndTime().toString());
//
//                preparedStatement.addBatch();
//                count++;
//            }
//
//            if (count % 10 == 0 || count == alertList.size()) {
//                preparedStatement.executeBatch();
//            }
//        } catch (SQLException e) {
//            System.out.println("Error setting insert statement user alerts: " + e);
//
//        }
//    }
//}
