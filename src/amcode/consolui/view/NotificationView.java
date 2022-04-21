package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.model.Alert;

import java.time.LocalTime;
import java.util.HashMap;

public class NotificationView extends FormView<Alert> {

    public NotificationView(HashMap<String, InputField> inputFields, Controller<Alert> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                LocalTime localTime = (LocalTime) getInputFields().get("notificationTime").getValue();

                System.out.println("Notification time: " + localTime);
                displayOptions();
                break;
            case FAIL:
                // TODO: if notification rejected, modify alert difficulty

                break;
            case SUCCESS:
                // TODO: if notification accepted, show exercise

                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<Alert> controller) {
        return null;
    }

    private void displayOptions() {
        System.out.println("Accept notification? [Y/N]");
        String choice = getScanner().nextLine();

        if (choice.equalsIgnoreCase("y")) {
            display(Display.SUCCESS);
        } else if (choice.equalsIgnoreCase("n")) {
            display(Display.FAIL);
        } else {
            System.out.println("Invalid input. Try again.");
            displayOptions();
        }
    }
}
