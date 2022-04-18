package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.consolui.view.form.input.TimeInputField;
import amcode.domain.model.Alert;

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

                String[] timeValues = displayEnterTime();
                String startTimeString = timeValues[0];
                String endTimeString = timeValues[1];

                LocalTime startTime = new TimeInputField().tryParse(startTimeString);
                LocalTime endTime = new TimeInputField().tryParse(endTimeString);

                getInputFields().put("alertName", new StringInputField(alertName));
                getInputFields().put("startTime", new TimeInputField(startTime));
                getInputFields().put("endTime", new TimeInputField(endTime));

                submit(getInputFields(), getController());
                break;
            case SUCCESS:
                break;
            case FAIL:
                break;
            default:
                break;
        }
    }


    @Override
    public void submit(HashMap<String, InputField> inputFields, Controller<Alert> controller) {
//        User loggedInUser = (User) getInputFields().get("logged_in_user").getValue();
//        controller.execute(getInputFields(), loggedInUser);
    }


    private void displayValidate(LocalTime localTime) {
        if (localTime == null) {
            System.out.println("Invalid time input. Try again.");
        }
    }


    private String[] displayEnterTime() {
        String[] timeArray = new String[2];

        System.out.println("Enter start time (ex. 08:00): ");
        String startTimeString = getScanner().nextLine();
        System.out.println("Enter end time (ex. 17:00): ");
        String endTimeString = getScanner().nextLine();

        timeArray[0] = startTimeString;
        timeArray[1] = endTimeString;

        return timeArray;
    }

}