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
import model.NotificationViewModel;
import view.form.FormView;
import view.form.input.IntegerInputField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class TriggerAlertView extends FormView<NotificationViewModel> {

    public TriggerAlertView(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        Displayable displayable;
        Display screen;

        switch (display) {
            case MAIN:
                createTitle();
                displayAlerts();
                break;
            case FAIL:
                System.out.println("Invalid option. Try again.");
                displayAlerts();
                break;
            case SUCCESS:
                DisplayScreen displayScreen = submit(getInputFields(), getController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller) {
        return controller.execute(getInputFields(), null);
    }

    private void displayAlerts() {
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        System.out.println("Choose an alert number: ");
        if (alertList.size() > 0) {
            // map to AlertViewModel
            List<AlertViewModel> alertViewModelList = new ArrayList<>();
            for (Alert alert : alertList) {
                AlertViewModel alertViewModel = new AlertViewMapping().mapFrom(alert);
                alertViewModelList.add(alertViewModel);
            }

            Displayable displayable = new AlertListView(getInputFields(), alertViewModelList, "Alerts list");
            displayable.display(Display.MAIN);

            System.out.println("_____________________________");
            displayChoice(alertList);
        } else {
            System.out.println("\tNo alerts ...");
            Displayable displayable = ViewFactory.getView(getInputFields(), View.ALERT_OPTIONS_VIEW);
            displayable.display(Display.MAIN);
            System.out.println("_____________________________");
        }
    }

    private void displayChoice(List<Alert> alertList) {
        int chosenNumber;

        try {
            chosenNumber = getScanner().nextInt();
            if (chosenNumber < 1 || chosenNumber > alertList.size()) {
                display(Display.FAIL);
            } else {
                getInputFields().put("chosenAlertIndex", new IntegerInputField(chosenNumber - 1));
                display(Display.SUCCESS);
            }
        } catch (InputMismatchException e) {
            display(Display.FAIL);
        }
    }

}
