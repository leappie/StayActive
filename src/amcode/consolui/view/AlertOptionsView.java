package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.consolui.common.mapping.AlertViewMapping;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.AlertViewModel;
import amcode.consolui.model.UserMainViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class AlertOptionsView extends FormView<UserMainViewModel> {

    public AlertOptionsView(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller, String screenTitle) {
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
                            // TODO: Modify Alert -> include delete alert
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
                    displayable = ViewFactory.getView(getInputFields(), View.ALERT_OPTIONS_VIEW);
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
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        // map to AlertViewModel
        List<AlertViewModel> alertViewModelList = new ArrayList<>();
        for (Alert alert : alertList) {
            AlertViewModel alertViewModel = new AlertViewMapping().mapFrom(alert);
            alertViewModelList.add(alertViewModel);
        }

        Displayable displayable = new AlertListView(alertViewModelList, "Alerts list");
        displayable.display(Display.MAIN);

        System.out.println("_____________________________");
    }
}
