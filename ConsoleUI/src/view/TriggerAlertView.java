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
                System.out.println("Choose an alert number.");

                try {
                    int choice = getScanner().nextInt();
                    getInputFields().put("alertIndexChoice", new IntegerInputField(choice));
                    display(Display.SUCCESS);

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    displayable = ViewFactory.getView(getInputFields(), View.ALERT_OPTIONS_VIEW);
                    displayable.display(Display.MAIN);
                }
                break;
            case FAIL:
                System.out.println("Invalid option.");
                display(Display.MAIN);
                break;
            case SUCCESS:
                DisplayScreen displayScreen = submit(getInputFields(), getController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller) {
        return controller.execute(getInputFields(), null);
    }


    // TODO: improve
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
