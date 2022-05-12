package controller;

import common.enums.Display;
import common.enums.View;
import common.interfaces.Controller;
import common.interfaces.Displayable;
import common.models.DisplayScreen;
import common.models.InputField;
import common.services.CurrentUserService;
import entity.Alert;
import entity.User;
import factory.ViewFactory;
import model.AlertViewModel;
import persistence.alert.AlertDAO;
import services.DeleteAlertService;

import java.util.HashMap;
import java.util.List;

public class DeleteAlertController implements Controller<AlertViewModel> {
    @Override
    public DisplayScreen execute(HashMap<String, InputField> inputField, AlertViewModel model) {
        Displayable displayable;
        Display screen;
        View view;

        int chosenIndex = (int) inputField.get("alertIndexChoice").getValue();
        User loggedInUser = CurrentUserService.getLoggedInUser();
        List<Alert> alertList = loggedInUser.getAlertList();

        // validate choice
        if (chosenIndex < 1 || chosenIndex > alertList.size()) {
            view = View.DELETE_ALERT_VIEW;
            screen = Display.FAIL;
        } else {
            // get alert
            Alert chosenAlert = loggedInUser.getAlertList().get(chosenIndex - 1);

            // Delete alert
            new DeleteAlertService(new AlertDAO()).deleteAlert(chosenAlert);

            // next view
            view = View.ALERT_OPTIONS_VIEW;
            screen = Display.MAIN;
        }

        displayable = ViewFactory.getView(inputField, view);
        return new DisplayScreen(displayable, screen);
    }
}
