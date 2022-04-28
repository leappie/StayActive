package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.controller.TriggerAlertController;
import amcode.consolui.model.NotificationViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;

public class NotificationView extends FormView<NotificationViewModel> {

    public NotificationView(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        DisplayScreen displayScreen;
        Displayable displayable;
        Display screen;

        switch (display) {
            case MAIN:
                String notificationTimeString = (String) getInputFields().get("notificationTime").getValue();

                System.out.println("Notification time: " + notificationTimeString);
                displayOptions();
                break;
            case FAIL:
                // if notification rejected, new notification
                displayScreen = submit(getInputFields(), new TriggerAlertController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
            case SUCCESS:
                // if notification accepted, show exercise
                // update notification to accepted
                displayScreen = submit(getInputFields(), getController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller) {
        return controller.execute(getInputFields(), null);
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
