package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.User;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class AlertListView extends FormView<AlertListView> {

    public AlertListView(HashMap<String, InputField> inputFields, Controller<AlertListView> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                createTitle();
                displayAlerts();
                displayInfo();
                Displayable displayable;

                try {
                    int choice = getScanner().nextInt();

                    switch (choice) {
                        case 1:
                            displayable = ViewFactory.getView(getInputFields(), View.NEW_ALERT_VIEW);
                            displayable.display(Display.MAIN);
                            break;
                        case 2:
                            // TODO: Modify Alert
                            System.out.println("TODO: Modify Alert");
                            display(Display.MAIN);
                            break;
                        case 3:
                            // TODO trigger alert
                            displayable = ViewFactory.getView(getInputFields(), View.TRIGGER_ALERT_VIEW);
                            displayable.display(Display.MAIN);
                            break;
                        case 4:
                            displayable = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
                            displayable.display(Display.MAIN);
                            break;
                        case 5:
                            // Quit
                            break;
                        default:
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    displayable = ViewFactory.getView(getInputFields(), View.ALERT_LIST_VIEW);
                    displayable.display(Display.MAIN);
                }
                break;
            default:
                break;
        }

    }

    @Override
    protected void displayInfo() {
        System.out.println(
                "Choose an option: \n" +
                        "\t1. Add new alert.\n" +
                        "\t2. Modify alert.\n" +
                        "\t3. Trigger alert.\n" +
                        "\t4. Back.\n" +
                        "\t5. Quit."
        );
    }

    private void displayAlerts() {
        User loggedInUser = (User) getInputFields().get("loggedInUser").getValue();
        List<Alert> alertList = loggedInUser.getAlertList();

        System.out.println("Current alerts: ");
        if (alertList.size() == 0) {
            System.out.println("\tNo alerts ...");
        } else {
            for (Alert alert : alertList) {
                System.out.println("\t" + alert);
            }
        }
        System.out.println("_____________________________");
    }
}
