package view;


import common.enums.Display;
import common.interfaces.Controller;
import common.models.DisplayScreen;
import common.models.InputField;
import entity.User;
import enums.Level;
import model.NewUserViewModel;
import view.form.FormView;
import view.form.input.StringInputField;

import java.util.HashMap;

public class NewAccountView extends FormView<NewUserViewModel> {
    public NewAccountView(HashMap<String, InputField> inputFields, Controller<NewUserViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
//        String username;
//        String password;
//        switch (display) {
//            case MAIN:
//                createTitle();
//
//                System.out.println("Set username: ");
//                username = getScanner().nextLine();
//                System.out.println("Set password: ");
//                password = getScanner().nextLine();
//
//                getInputFields().put("username", new StringInputField(username));
//                getInputFields().put("password", new StringInputField(password));
//
//                displayInputLevel();
//                break;
//            case FAIL:
//                displayInputLevel();
//                break;
//            case SUCCESS:
//                DisplayScreen displayScreen = submit(getInputFields(), getController());
//                FormView formView = (FormView) displayScreen.getFormView();
//                Display screen = displayScreen.getDisplay();
//
//                formView.display(screen);
//                break;
//            default:
//                break;
//        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<NewUserViewModel> controller) {
        final String username = (String) getInputFields().get("username").getValue();
        final String password = (String) getInputFields().get("password").getValue();
        final Level level = (Level) getInputFields().get("userLevel").getValue();

        User user = new User(username, password, level);

//        return controller.execute(getInputFields(), user);
        return null;
    }


//    private void displayInputLevel() {
//        System.out.println("Set user exercise level, beginner or experienced. [B/E] ");
//        String value = getScanner().nextLine();
//        Level level = new LevelInputField().tryParseUserLevel(value);
//
//        if (level != null) {
//            getInputFields().put("userLevel", new LevelInputField(level));
//            display(Display.SUCCESS);
//        } else {
//            System.out.println("Invalid input. Try again.");
//            display(Display.FAIL);
//        }
//    }
}