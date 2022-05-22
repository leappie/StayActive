package persistence.alertexercise;

import common.interfaces.daos.IAlertExerciseDAO;
import entity.Alert;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.alertexercise.commands.DeleteAlertExerciseCommand;
import persistence.alertexercise.commands.InsertAlertExerciseCommand;
import persistence.alertexercise.commands.UpdateAlertExerciseCommand;
import persistence.alertexercise.queries.SelectAlertExercisesQuery;

import javax.sql.DataSource;
import java.util.List;

public class AlertExerciseDAO implements IAlertExerciseDAO {
    private DataStore<Alert> dataStore = new DataStore<>();
    private DataSource dataSource;

    public AlertExerciseDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AlertExerciseDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(Alert alert) {
        return this.dataStore.execute(new InsertAlertExerciseCommand(this.dataSource), alert);
    }

    @Override
    public long update(Alert alert) {
        return this.dataStore.execute(new UpdateAlertExerciseCommand(this.dataSource), alert);
    }

    @Override
    public void delete(Alert alert) {
        this.dataStore.execute(new DeleteAlertExerciseCommand(this.dataSource), alert);
    }

    @Override
    public List<Alert> query(Alert alert) {
        return this.dataStore.query(new SelectAlertExercisesQuery(this.dataSource, alert));
    }


}
