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
////        List<User> userList =  dataStore.query(new UserSelectQuery(), new User("test12", "1234"));
////        System.out.println(userList);
//
//        long id = dataStore.execute(new UserInsertCommand(), new User(2,"test", "mod", Level.EASY));
//        System.out.println(id);


    }
}
