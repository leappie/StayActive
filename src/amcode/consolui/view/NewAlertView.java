package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.consolui.view.form.input.TimeInputField;
import amcode.domain.entity.Alert;

import java.time.LocalTime;
import java.util.HashMap;

public class NewAlertView extends FormView<Alert> {
    private LocalTime startTime = null;
    private LocalTime endTime = null;

    public NewAlertView(HashMap<String, InputField> inputFields, Controller<Alert> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                createTitle();

                System.out.println("Enter alert name: ");
                String alertName = getScanner().nextLine();
                getInputFields().put("alertName", new StringInputField(alertName));
                displayEnterTime();
                break;
            case FAIL:
                System.out.println("Invalid time input. Try again.");
                displayEnterTime();
                break;
            case SUCCESS:
                DisplayScreen displayScreen = submit(getInputFields(), getController());
                FormView formView = (FormView) displayScreen.getFormView();
                Display screen = displayScreen.getDisplay();

                formView.display(screen);
                break;
            default:
                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<Alert> controller) {
//        final String alertName = (String) getInputFields().get("alertName").getValue();
//        final LocalTime startTime = (LocalTime) getInputFields().get("startTime").getValue();
//        final LocalTime endTime = (LocalTime) getInputFields().get("endTime").getValue();
//
//        Interval interval = new Interval(startTime, endTime);
//        Alert alert = new Alert(alertName, interval);
//
//        return controller.execute(getInputFields(), alert);
        return null;
    }


    private void displayEnterTime() {
        System.out.println("Enter start time (ex. 08:00): ");
        String startTimeString = getScanner().nextLine();
        System.out.println("Enter end time (ex. 17:00): ");
        String endTimeString = getScanner().nextLine();

        LocalTime startTime = new TimeInputField().tryParse(startTimeString);
        LocalTime endTime = new TimeInputField().tryParse(endTimeString);

        if (startTime != null && endTime != null) {
            getInputFields().put("startTime", new TimeInputField(startTime));
            getInputFields().put("endTime", new TimeInputField(endTime));
            display(Display.SUCCESS);
        } else {
            display(Display.FAIL);
        }
    }

}