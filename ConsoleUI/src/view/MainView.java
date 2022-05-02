package view;


import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import factory.ViewFactory;
import model.UserMainViewModel;
import view.form.FormView;
import view.form.input.IntegerInputField;
import view.form.input.StringInputField;

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
                    getInputFields().put("mainViewChoice", new IntegerInputField(choice));

                    DisplayScreen displayScreen = submit(getInputFields(), getController());
                    displayable = displayScreen.getFormView();
                    screen = displayScreen.getDisplay();
                    displayable.display(screen);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    displayable = ViewFactory.getView(getInputFields(), View.MAIN_VIEW);
                    displayable.display(Display.MAIN);
                }
                break;
            case FAIL:
                System.out.println("Invalid Option.");
                display(Display.MAIN);
                break;
            case QUIT:
                // Quit
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
