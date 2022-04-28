package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.application.common.enums.View;
import amcode.application.common.interfaces.Controller;
import amcode.application.common.interfaces.Displayable;
import amcode.application.common.models.DisplayScreen;
import amcode.consolui.factory.ViewFactory;
import amcode.consolui.model.UserMainViewModel;
import amcode.consolui.view.form.FormView;
import amcode.consolui.view.form.input.InputField;
import amcode.consolui.view.form.input.StringInputField;

import java.util.HashMap;
import java.util.InputMismatchException;

public class MainView extends FormView<UserMainViewModel> {

    public MainView(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                createTitle();
                displayInfo();
                Displayable displayable;
                Display screen;

                try {
                    int choice = getScanner().nextInt();

                    switch (choice) {
                        case 1:
                            // TODO: view profile
                            System.out.println("TODO: view profile");
                            getInputFields().put("showNextView", new StringInputField(View.PROFILE_VIEW.toString()));
                            display(Display.MAIN);
                            break;
                        case 2:
                            getInputFields().put("showNextView", new StringInputField(View.ALERT_OPTIONS_VIEW.toString()));
                            DisplayScreen displayScreen = submit(getInputFields(), getController());
                            displayable = displayScreen.getFormView();
                            screen = displayScreen.getDisplay();
                            displayable.display(screen);
                            break;
                        case 3:
                            // TODO: view exercise history
                            System.out.println("TODO: view exercise history");
                            getInputFields().put("showNextView", new StringInputField(View.EXERCISE_HISTORY_VIEW.toString()));
                            display(Display.MAIN);
                            break;
                        case 4:
                            // Quit
                            break;
                        default:
                            System.out.println("Invalid Option.");
                            display(Display.MAIN);
                            break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    displayable = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
                    displayable.display(Display.MAIN);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller) {
        UserMainViewModel userMainViewModel = new UserMainViewModel();
        return controller.execute(inputFields, userMainViewModel);
    }


}
