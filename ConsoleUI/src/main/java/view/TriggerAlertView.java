package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.NotificationViewModel;
import view.form.FormView;
import view.form.input.IntegerInputField;

import java.util.HashMap;
import java.util.InputMismatchException;

// TODO: Make a general choose alert view for trigger and delete alert with display screen options 1 and option 2
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


//    // TODO: improve
//    private void displayAlerts() {
//        User loggedInUser = CurrentUserService.getLoggedInUser();
//        List<Alert> alertList = loggedInUser.getAlertList();
//
//        // map to AlertViewModel
//        List<AlertViewModel> alertViewModelList = new ArrayList<>();
//        for (Alert alert : alertList) {
//            AlertViewModel alertViewModel = new AlertViewMapping().mapFrom(alert);
//            alertViewModelList.add(alertViewModel);
//        }
//
//        Displayable displayable = new AlertListView(getInputFields(), alertViewModelList, "Alerts list");
//        displayable.display(Display.MAIN);
//
//        System.out.println("_____________________________");
//    }

}
