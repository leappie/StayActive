package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.common.services.CurrentUserService;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.AlertViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.IntegerInputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.User;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class TriggerAlertView extends FormView<AlertViewModel> {

    public TriggerAlertView(HashMap<String, InputField> inputFields, Controller<AlertViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                FormView formView;
                createTitle();
                displayAlerts();
                break;
            case FAIL:
                System.out.println("Invalid option. Try again.");
                displayAlerts();
                break;
            case SUCCESS:
                DisplayScreen displayScreen = submit(getInputFields(), getController());
                formView = (FormView) displayScreen.getFormView();
                Display screen = displayScreen.getDisplay();
                formView.display(screen);
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<AlertViewModel> controller) {
        final Alert chosenAlert = (Alert) inputFields.get("chosenTriggerAlert").getValue();

        return controller.execute(getInputFields(), null);
    }

    private void displayAlerts() {
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        System.out.println("Choose an alert number: ");
        if (alertList.size() > 0) {
            for (int i = 0; i < alertList.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + alertList.get(i));
            }
            System.out.println("_____________________________");
            displayChoice(alertList);
        } else {
            System.out.println("\tNo alerts ...");
            FormView formView = ViewFactory.getView(getInputFields(), View.ALERT_OPTIONS_VIEW);
            formView.display(Display.MAIN);
            System.out.println("_____________________________");
        }
    }

    private void displayChoice(List<Alert> alertList) {
        int chosenNumber;

        try {
            chosenNumber = getScanner().nextInt();
            System.out.println("chosen alert number: " + chosenNumber);

            if (chosenNumber < 1 || chosenNumber > alertList.size()) {
                display(Display.FAIL);
            } else {
//                Alert chosenAlert = alertList.get(chosenNumber - 1);
                getInputFields().put("chosenAlertIndex", new IntegerInputField(chosenNumber - 1));
                display(Display.SUCCESS);
            }
        } catch (InputMismatchException e) {
            display(Display.FAIL);
        }
    }

}
