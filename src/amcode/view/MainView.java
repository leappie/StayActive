package amcode.view;


import amcode.controller.AlertListController;
import amcode.controller.Controller;
import amcode.model.domain.User;
import amcode.view.factory.ViewEnum;
import amcode.view.factory.ViewFactory;
import amcode.view.form.DisplayEnum;
import amcode.view.form.FormView;
import amcode.view.form.input.InputField;

import java.util.HashMap;

public class MainView extends FormView<User> {

    public MainView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(DisplayEnum display) {
        switch (display) {
            case MAIN:
                displayInfo();
                int choice = getScanner().nextInt();
                // TODO validate input
                FormView formView;

                switch (choice) {
                    case 1:
                        // TODO: view profile
//                        formView = ViewFactory.getView(getInputFields(), ViewEnum.PROFILE_VIEW);
//                        formView.display(DisplayEnum.MAIN);
                        break;
                    case 2:
                        formView = ViewFactory.getView(getInputFields(), ViewEnum.ALERT_LIST_VIEW);
                        formView.display(DisplayEnum.MAIN);
                        break;
                    case 3:
                        // TODO: view exercise history
//                        formView = ViewFactory.getView(getInputFields(), ViewEnum.EXERCISE_HISTORY_VIEW);
//                        formView.display(DisplayEnum.MAIN);
                        break;
                    case 4:
                        // Quit
                        break;
                    default:
                        // Quit
                        break;
                }
                break;
            default:
                break;
        }

    }

    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {

    }
}
