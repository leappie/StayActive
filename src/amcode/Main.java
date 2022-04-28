package amcode;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;

public class Main {

    public static void main(String[] args) {
        FormView formView = ViewFactory.getView(View.START_VIEW);
        formView.display(Display.MAIN);

//        DataStore dataStore = new DataStore();
//        List<Alert> alertList = new ArrayList<>();
//        alertList.add(new Alert("alert 1", new Interval(LocalTime.of(8, 30), LocalTime.of(12,30))));
//        UserAlertsDTO userAlertsDTO = new UserAlertsDTO(new User("test", "1234"), alertList);
//        List<UserAlertsDTO> userAlertsDTOS = dataStore.query(new SelectUserAlertsQuery(), userAlertsDTO);

//        System.out.println(userAlertsDTOS);



//        List<User> userList =  dataStore.query(new UserSelectQuery(), new User("test12", "1234"));
//        System.out.println(userList);
//
//        long id = dataStore.execute(new UserInsertCommand(), new User(2,"test", "mod", Level.EASY));
//        System.out.println(id);


    }
}
