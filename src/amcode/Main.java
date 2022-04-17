package amcode;

import amcode.application.enums.Display;
import amcode.application.enums.View;
import amcode.consolui.view.factory.ViewFactory;
import amcode.consolui.view.form.FormView;

public class Main {

    public static void main(String[] args) {
        FormView formView = ViewFactory.getView(View.LOGIN_VIEW);
        formView.display(Display.MAIN);

    }
}
