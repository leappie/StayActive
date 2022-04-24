package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.AlertInputField;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.Alert;
import amcode.domain.entity.User;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class TriggerAlertView extends FormView<Alert> {
    private User loggedInUser;
    private List<Alert> alertList;

    public TriggerAlertView(HashMap<String, InputField> inputFields, Controller<Alert> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
        this.loggedInUser = (User) getInputFields().get("loggedInUser").getValue();
        this.alertList = this.loggedInUser.getAlertList();
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
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<Alert> controller) {
        final Alert chosenAlert = (Alert) inputFields.get("chosenTriggerAlert").getValue();

        return controller.execute(getInputFields(), chosenAlert);
    }

    private void displayAlerts() {
        System.out.println("Choose an alert number: ");
        if (this.alertList.size() > 0) {
            for (int i = 0; i < this.alertList.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + this.alertList.get(i));
            }
            System.out.println("_____________________________");
            displayChoice();
        } else {
            System.out.println("\tNo alerts ...");
            FormView formView = ViewFactory.getView(getInputFields(), View.ALERT_LIST_VIEW);
            formView.display(Display.MAIN);
            System.out.println("_____________________________");
        }
    }

    private void displayChoice() {
        int chosenNumber;

        try {
            chosenNumber = getScanner().nextInt();
            System.out.println("chosen: " + chosenNumber);

            if (chosenNumber < 1 || chosenNumber > this.alertList.size()) {
                display(Display.FAIL);
            } else {
                System.out.println(this.alertList);
                Alert chosenAlert = this.alertList.get(chosenNumber - 1);
                getInputFields().put("chosenTriggerAlert", new AlertInputField(chosenAlert));
                display(Display.SUCCESS);
            }
        } catch (InputMismatchException e) {
            display(Display.FAIL);
        }
    }

}
