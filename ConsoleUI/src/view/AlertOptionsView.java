package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.mapping.AlertViewMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.Alert;
import entity.User;
import factory.ViewFactory;
import model.AlertViewModel;
import model.UserMainViewModel;
import view.form.FormView;

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
                            // TODO: Modify Alert
                            System.out.println("TODO: Modify Alert");
                            display(Display.MAIN);
                            break;
                        case 3:
                            // TODO: Delete Alert
                            System.out.println("TODO: Delete Alert");
                            display(Display.MAIN);
                            break;
                        case 4:
                            displayable = ViewFactory.getView(getInputFields(), View.TRIGGER_ALERT_VIEW);
                            displayable.display(Display.MAIN);
                            break;
                        case 5:
                            displayable = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
                            displayable.display(Display.MAIN);
                            break;
                        case 6:
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
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller) {
        return null;
    }

    @Override
    protected void displayInfo() {
        System.out.println(
                "Choose an option: \n" +
                        "\t1. Add new alert.\n" +
                        "\t2. Modify alert.\n" +
                        "\t3. Delete alert. \n" +
                        "\t4. Trigger alert.\n" +
                        "\t5. Back.\n" +
                        "\t6. Quit."
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

        Displayable displayable = new AlertListView(getInputFields(), alertViewModelList, "Alerts list");
        displayable.display(Display.MAIN);

        System.out.println("_____________________________");
    }
}
