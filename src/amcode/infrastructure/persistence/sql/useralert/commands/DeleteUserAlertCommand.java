//package amcode.infrastructure.persistence.sql.useralert.commands;
//
//import amcode.application.common.dtos.UserAlertsDTO;
//import amcode.domain.entity.Alert;
//import amcode.infrastructure.persistence.sql.DatabaseCommand;
//import amcode.infrastructure.persistence.sql.interfaces.AlertTable;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//public class DeleteUserAlertCommand extends DatabaseCommand<UserAlertsDTO> implements AlertTable {
//    @Override
//    protected String getCommandText() {
//        String query = String.format(
//                "DELETE FROM %s " +
//                "WHERE %s = ?",
//                TABLE, COLUMN_ID);
//        return query;
//    }
//
//    @Override
//    protected void setParams(PreparedStatement preparedStatement, UserAlertsDTO data) {
//        try {
//            List<Alert> alertList = data.getAlertList();
//            int count = 0;
//
//            for (Alert alert : alertList) {
//                preparedStatement.setInt(3, alert.getId());
//
//                preparedStatement.addBatch();
//                count++;
//            }
//
//            if (count % 10 == 0 || count == alertList.size()) {
//                preparedStatement.executeBatch();
//            }
//        } catch (SQLException e) {
//            System.out.println("Error setting update statement: " + e);
//
//        }
//    }
//}
