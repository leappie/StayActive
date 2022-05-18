package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.mapping.AlertViewModelMapping;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.Alert;
import entity.User;
import factory.ViewFactory;
import model.AlertViewModel;
import model.UserMainViewModel;
import view.form.FormView;
import view.form.input.IntegerInputField;

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
        Displayable displayable;
        Display screen;

        switch (display) {
            case MAIN:
                createTitle();
                displayAlerts();
                displayInfo();

                try {
                    int choice = getScanner().nextInt();
                    getScanner().nextLine();
                    getInputFields().put("alertOptionsViewChoice", new IntegerInputField(choice));

                    DisplayScreen displayScreen = submit(getInputFields(), getController());
                    displayable = displayScreen.getFormView();
                    screen = displayScreen.getDisplay();
                    displayable.display(screen);
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
            case QUIT:
                // QUIT
                break;
            default:
                break;
        }

    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller) {
        return controller.execute(inputFields, null);
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

    // TODO: improve
    private void displayAlerts() {
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        // map to AlertViewModel
        List<AlertViewModel> alertViewModelList = new ArrayList<>();
        for (Alert alert : alertList) {
            AlertViewModel alertViewModel = new AlertViewModelMapping().mapToModel(alert);
            alertViewModelList.add(alertViewModel);
        }

        Displayable displayable = new AlertListView(getInputFields(), alertViewModelList, "Alerts list");
        displayable.display(Display.MAIN);

        System.out.println("_____________________________");
    }
}
