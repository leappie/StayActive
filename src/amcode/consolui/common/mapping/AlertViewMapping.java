package amcode.consolui.common.mapping;

import amcode.application.common.interfaces.Mapping;
import amcode.application.common.util.LocalTimeConverter;
import amcode.consolui.model.AlertViewModel;
import amcode.domain.entity.Alert;
import amcode.domain.entity.Interval;

import java.time.LocalTime;

public class AlertViewMapping implements Mapping<AlertViewModel, Alert> {
    @Override
    public Alert mapTo(AlertViewModel viewModel) {
        LocalTimeConverter localTimeConverter = new LocalTimeConverter();
        LocalTime startTime = localTimeConverter.tryParse(viewModel.getStartTime());
        LocalTime endTime = localTimeConverter.tryParse(viewModel.getEndTime());

        if (startTime != null && endTime != null) {
            return new Alert(viewModel.getAlertName(), new Interval(startTime, endTime));
        }
        return null;
    }

    @Override
    public AlertViewModel mapFrom(Alert entity) {
        return new AlertViewModel(entity.getId(), entity.getName(), entity.getInterval().getStartTime().toString(),
                entity.getInterval().getEndTime().toString());
    }
}
