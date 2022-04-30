package common.mapping;

import common.interfaces.Mapping;
import common.util.LocalTimeConverter;
import entity.Alert;
import entity.Interval;
import model.AlertViewModel;

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
