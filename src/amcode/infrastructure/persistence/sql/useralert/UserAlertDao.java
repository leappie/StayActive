//package amcode.infrastructure.persistence.sql.useralert;
//
//import amcode.application.common.dtos.UserAlertsDTO;
//import amcode.application.common.interfaces.daos.IUserAlertDao;
//import amcode.infrastructure.persistence.sql.DatabaseCommand;
//import amcode.infrastructure.persistence.sql.DatabaseQuery;
//import amcode.infrastructure.persistence.sql.useralert.commands.DeleteUserAlertCommand;
//import amcode.infrastructure.persistence.sql.useralert.commands.InsertUserAlertCommand;
//import amcode.infrastructure.persistence.sql.useralert.commands.UpdateUserAlertCommand;
//import amcode.infrastructure.persistence.sql.useralert.queries.SelectUserAlertsQuery;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class UserAlertDao implements IUserAlertDao {
//    private DatabaseQuery<UserAlertsDTO> userAlertsDTOQuery;
//    private HashMap<String, DatabaseCommand<UserAlertsDTO>> userAlertsDTOCommandList;
//
//    public UserAlertDao(DatabaseQuery<UserAlertsDTO> userAlertsDTOQuery, HashMap<String,
//            DatabaseCommand<UserAlertsDTO>> userAlertsDTOCommandList) {
//        this.userAlertsDTOQuery = userAlertsDTOQuery;
//        this.userAlertsDTOCommandList = userAlertsDTOCommandList;
//    }
//
//    public UserAlertDao() {
//        /*
//        For convenience
//         */
//        this.userAlertsDTOQuery = new SelectUserAlertsQuery();
//        this.userAlertsDTOCommandList = new HashMap<>();
//        this.userAlertsDTOCommandList.put("insert", new InsertUserAlertCommand());
//        this.userAlertsDTOCommandList.put("update", new UpdateUserAlertCommand());
//        this.userAlertsDTOCommandList.put("delete", new DeleteUserAlertCommand());
//    }
//
//
//    @Override
//    public long insertUser(UserAlertsDTO userAlertsDTO) {
//        return this.userAlertsDTOCommandList.get("insert").execute(userAlertsDTO);
//    }
//
//    @Override
//    public long updateUser(UserAlertsDTO userAlertsDTO) {
//        return this.userAlertsDTOCommandList.get("update").execute(userAlertsDTO);
//    }
//
//    @Override
//    public long deleteUser(UserAlertsDTO userAlertsDTO) {
//        return this.userAlertsDTOCommandList.get("delete").execute(userAlertsDTO);
//    }
//
//    @Override
//    public List<UserAlertsDTO> getUserAlerts(UserAlertsDTO userAlertsDTO) {
//        return this.userAlertsDTOQuery.execute(userAlertsDTO);
//    }
//}
