package view;

import common.enums.Display;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import controller.TriggerAlertController;
import model.NotificationViewModel;
import view.form.FormView;
import view.form.input.StringInputField;

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
                createTitle();
                String notificationTimeString = (String) getInputFields().get("notificationTime").getValue();
                System.out.println("Notification time: " + notificationTimeString);

                System.out.println("Accept notification? [Y/N]");
                String choice = getScanner().nextLine();

                getInputFields().put("notificationViewChoice", new StringInputField(choice));
                displayScreen = submit(getInputFields(), getController());
                displayable = displayScreen.getFormView();
                screen = displayScreen.getDisplay();
                displayable.display(screen);
                break;
            case FAIL:
                System.out.println("Invalid Option.");
                display(Display.MAIN);
                break;
        }
    }


    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NotificationViewModel> controller) {
        return controller.execute(getInputFields(), null);
    }

}
