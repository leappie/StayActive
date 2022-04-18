package amcode;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;

public class Main {

    public static void main(String[] args) {
        FormView formView = ViewFactory.getView(View.START_VIEW);
        formView.display(Display.MAIN);

    }
}
