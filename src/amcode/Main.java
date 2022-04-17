package amcode;

import amcode.view.factory.ViewEnum;
import amcode.view.factory.ViewFactory;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;


public class Main {

    public static void main(String[] args) {
        FormView formView = ViewFactory.getView(ViewEnum.LOGIN_VIEW);
        formView.display(DisplayEnum.MAIN);

    }
}
