package view;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.AlertViewModel;
import view.form.FormView;
import view.form.input.StringInputField;

import java.util.HashMap;

public class NewAlertView extends FormView<AlertViewModel> {

    public NewAlertView(HashMap<String, InputField> inputFields, Controller<AlertViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        Displayable displayable;
        Display screen;

        switch (display) {
            case MAIN:
                createTitle();

                System.out.println("Enter alert name: ");
                String alertName = getScanner().nextLine();
                getInputFields().put("alertName", new StringInputField(alertName));

                System.out.println("Enter start time (ex. 08:00): ");
                String startTimeString = getScanner().nextLine();
                getInputFields().put("startTime", new StringInputField(startTimeString));

                System.out.println("Enter end time (ex. 17:00): ");
                String endTimeString = getScanner().nextLine();
                getInputFields().put("endTime", new StringInputField(endTimeString));

                DisplayScreen displayScreen = submit(getInputFields(), getController());
                displayable =  displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
            case FAIL:
                System.out.println("Duplicate name or invalid interval.");
                displayable = ViewFactory.getView(getInputFields(), View.ALERT_OPTIONS_VIEW);
                displayable.display(Display.MAIN);
                break;
            default:
                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<AlertViewModel> controller) {
        final String alertName = (String) getInputFields().get("alertName").getValue();
        final String startTime = (String) getInputFields().get("startTime").getValue();
        final String endTime = (String) getInputFields().get("endTime").getValue();

        // map to AlertViewModel
        AlertViewModel alertViewModel = new AlertViewModel(0, alertName, startTime, endTime);

        return controller.execute(getInputFields(), alertViewModel);
    }

}