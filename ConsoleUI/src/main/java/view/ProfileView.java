package view;


import common.enums.Display;
import common.models.InputField;
import model.UserMainViewModel;
import view.data.DataView;

import java.util.HashMap;

// TODO: Profile view
public class ProfileView extends DataView<UserMainViewModel> {

    public ProfileView(HashMap<String, InputField> inputFields, UserMainViewModel model, String screenTitle) {
        super(inputFields, model, screenTitle);
    }

    @Override
    public void display(Display display) {

    }

}