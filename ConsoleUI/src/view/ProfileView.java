package view;


import common.enums.Display;
import common.interfaces.Controller;
import common.models.DisplayScreen;
import common.models.InputField;
import model.UserMainViewModel;
import view.form.FormView;

import java.util.HashMap;

// TODO: Profile view
public class ProfileView extends FormView<UserMainViewModel> {
    public ProfileView(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller, String screenTitle) {
        super(inputFields, controller, screenTitle);
    }

    @Override
    public void display(Display display) {

    }

    @Override
    public DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<UserMainViewModel> controller) {
        return null;
    }
}