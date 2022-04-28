package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.controller.TriggerAlertController;
import amcode.consolui.model.NotificationViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.domain.entity.Alert;

import java.util.HashMap;

public class NotificationView extends FormView<NotificationViewModel> {

    public NotificationView(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        FormView formView;
        Display screen;

        switch (display) {
            case MAIN:
                String notificationTimeString = (String) getInputFields().get("notificationTime").getValue();

                System.out.println("Notification time: " + notificationTimeString);
                displayOptions();
                break;
            case FAIL:
                // if notification rejected, new notification
                DisplayScreen displayScreen = submit(getInputFields(), new TriggerAlertController());
                formView = (FormView) displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                formView.display(screen);
                break;
            case SUCCESS:
                // TODO: if notification accepted, show exercise
                // TODO update notification to accepted
//                formView = ViewFactory.getView(View.ON_EXERCISE_VIEW);
//                formView.display(Display.MAIN);
                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller) {
        final Alert chosenAlert = (Alert) inputFields.get("chosenTriggerAlert").getValue();

//        return controller.execute(getInputFields(), chosenAlert);
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
