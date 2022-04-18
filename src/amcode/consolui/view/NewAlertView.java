package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.consolui.view.form.input.TimeInputField;
import amcode.domain.model.Alert;
import amcode.domain.model.Interval;

import java.time.LocalTime;
import java.util.HashMap;

public class NewAlertView extends FormView<Alert> {
    private LocalTime startTime = null;
    private LocalTime endTime = null;

    public NewAlertView(HashMap<String, InputField> inputFields, Controller<Alert> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {

        switch (display) {
            case MAIN:
                System.out.println("Enter alert name: ");
                String alertName = getScanner().nextLine();
                getInputFields().put("alertName", new StringInputField(alertName));
                displayEnterTime();

                break;
            case FAIL:
                displayEnterTime();
                break;
            case SUCCESS:
                submit(getInputFields(), getController());
                break;
            default:
                break;
        }
    }


    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<Alert> controller) {
        final String alertName = (String) getInputFields().get("alertName").getValue();
        final LocalTime startTime = (LocalTime) getInputFields().get("startTime").getValue();
        final LocalTime endTime = (LocalTime) getInputFields().get("endTime").getValue();

        Interval interval = new Interval(startTime, endTime);
        Alert alert = new Alert(alertName, interval);

        controller.execute(getInputFields(), alert);
    }


    private void displayEnterTime() {
        System.out.println("Enter start time (ex. 08:00): ");
        String startTimeString = getScanner().nextLine();
        System.out.println("Enter end time (ex. 17:00): ");
        String endTimeString = getScanner().nextLine();

        LocalTime startTime = new TimeInputField().tryParse(startTimeString);
        LocalTime endTime = new TimeInputField().tryParse(endTimeString);

        if (startTime != null || endTime != null) {
            getInputFields().put("startTime", new TimeInputField(startTime));
            getInputFields().put("endTime", new TimeInputField(endTime));
            display(Display.SUCCESS);
        } else {
            System.out.println("Invalid time input. Try again.");
            display(Display.FAIL);
        }
    }

}