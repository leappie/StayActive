package persistence.alertexercise;

import common.interfaces.DAO;
import entity.Alert;
import persistence.DataStore;
import persistence.alert.queries.SelectAlertQuery;
import persistence.alertexercise.commands.DeleteAlertExerciseCommand;
import persistence.alertexercise.commands.InsertAlertExerciseCommand;
import persistence.alertexercise.commands.UpdateAlertExerciseCommand;
import persistence.alertexercise.queries.SelectAlertExercisesQuery;

import java.util.List;

public class AlertExerciseDAO implements DAO<Alert> {
    private DataStore<Alert> dataStore = new DataStore<>();

    @Override
    public long insert(Alert entity) {
        return this.dataStore.execute(new InsertAlertExerciseCommand(), entity);
    }

    @Override
    public long update(Alert entity) {
        return this.dataStore.execute(new UpdateAlertExerciseCommand(), entity);
    }

    @Override
    public long delete(Alert entity) {
        return this.dataStore.execute(new DeleteAlertExerciseCommand(), entity);
    }

    @Override
    public List<Alert> query(Alert entity) {
        return this.dataStore.query(new SelectAlertExercisesQuery(), entity);
    }


}
