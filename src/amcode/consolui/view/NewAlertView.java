package amcode.consolui.view;

import amcode.application.enums.Display;
import amcode.application.interfaces.Controller;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;
import amcode.consolui.view.form.input.StringToTimeInputField;
import amcode.domain.model.User;

import java.util.HashMap;

public class NewAlertView extends FormView<User> {

    public NewAlertView(HashMap<String, InputField> inputFields, Controller<User> controller) {
        super(inputFields, controller);
    }

    @Override
    public void display(Display display) {

        switch (display) {
            case MAIN:
                System.out.println("Enter alert name: ");
                String alertName = getScanner().nextLine();
                System.out.println("Enter start time (ex. 08:00): ");
                String startTime = getScanner().nextLine();
                System.out.println("Enter end time (ex. 17:00): ");
                String endTime = getScanner().nextLine();
                // TODO: validate input

                getInputFields().put("alertName", new StringInputField(alertName));
                getInputFields().put("startTime", new StringToTimeInputField(startTime)); // TODO: convert to LocalTime (NOT HERE!)
                getInputFields().put("endTime", new StringToTimeInputField(endTime));

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
    public void submit(HashMap<String, InputField> inputFields, Controller<User> controller) {
        User loggedInUser = (User) getInputFields().get("logged_in_user").getValue();
        controller.execute(getInputFields(), loggedInUser);


    }





}