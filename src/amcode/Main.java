package amcode;

import amcode.application.common.dtos.UserAlertsDTO;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Interval;
import amcode.domain.entity.User;
import amcode.infrastructure.persistence.sql.DataStore;
import amcode.infrastructure.persistence.sql.useralert.queries.SelectUserAlertsQuery;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        FormView formView = ViewFactory.getView(View.START_VIEW);
//        formView.display(Display.MAIN);

        DataStore dataStore = new DataStore();
        List<Alert> alertList = new ArrayList<>();
        alertList.add(new Alert("alert 1", new Interval(LocalTime.of(8, 30), LocalTime.of(12,30))));
        UserAlertsDTO userAlertsDTO = new UserAlertsDTO(new User("test", "1234"), alertList);
        List<UserAlertsDTO> userAlertsDTOS = dataStore.query(new SelectUserAlertsQuery(), userAlertsDTO);

        System.out.println(userAlertsDTOS);



//        List<User> userList =  dataStore.query(new UserSelectQuery(), new User("test12", "1234"));
//        System.out.println(userList);
//
//        long id = dataStore.execute(new UserInsertCommand(), new User(2,"test", "mod", Level.EASY));
//        System.out.println(id);


    }
}
