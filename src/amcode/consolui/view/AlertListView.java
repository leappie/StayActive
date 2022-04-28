package amcode.consolui.view;

import amcode.application.common.enums.Display;
import amcode.consolui.model.AlertViewModel;
import amcode.consolui.view.data.DataView;
import amcode.consolui.view.form.input.InputField;

import java.util.HashMap;
import java.util.List;

public class AlertListView extends DataView<List<AlertViewModel>> {

    public AlertListView(HashMap<String, InputField> inputFields, List<AlertViewModel> model, String screenTitle) {
        super(inputFields, model, screenTitle);
    }

    @Override
    public void display(Display display) {
        switch (display) {
            case MAIN:
                displayAlerts();
                break;
        }
    }

    private void displayAlerts() {
        int count = 1;
        for (AlertViewModel alertViewModel : getModel()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                    .append("\t")
                    .append(count)
                    .append(" ")
                    .append(alertViewModel.getAlertName())
                    .append(" (")
                    .append(alertViewModel.getStartTime())
                    .append("-")
                    .append(alertViewModel.getEndTime())
                    .append(")");
            System.out.println(stringBuilder);
            count ++;
        }
    }
}
