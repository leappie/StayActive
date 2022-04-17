package amcode;

import amcode.controller.Controller;
import amcode.controller.LoginController;
import amcode.model.domain.User;
import amcode.view.factory.ViewEnum;
import amcode.view.factory.ViewFactory;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;


public class Main {

    public static void main(String[] args) {

        Controller<User> controller = new LoginController();
        FormView formView = ViewFactory.getView(controller, ViewEnum.LOGIN);
        formView.display(DisplayEnum.MAIN);
    }
}
