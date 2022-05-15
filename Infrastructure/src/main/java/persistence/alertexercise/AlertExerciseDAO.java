package persistence.alertexercise;

import common.interfaces.DAO;
import entity.Alert;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.alertexercise.commands.DeleteAlertExerciseCommand;
import persistence.alertexercise.commands.InsertAlertExerciseCommand;
import persistence.alertexercise.commands.UpdateAlertExerciseCommand;
import persistence.alertexercise.queries.SelectAlertExercisesQuery;

import javax.sql.DataSource;
import java.util.List;

public class AlertExerciseDAO implements DAO<Alert> {
    private DataStore<Alert> dataStore = new DataStore<>();
    private DataSource dataSource;

    public AlertExerciseDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AlertExerciseDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(Alert entity) {
        return this.dataStore.execute(new InsertAlertExerciseCommand(this.dataSource), entity);
    }

    @Override
    public long update(Alert entity) {
        return this.dataStore.execute(new UpdateAlertExerciseCommand(this.dataSource), entity);
    }

    @Override
    public long delete(Alert entity) {
        return this.dataStore.execute(new DeleteAlertExerciseCommand(this.dataSource), entity);
    }

    @Override
    public List<Alert> query(Alert entity) {
        return this.dataStore.query(new SelectAlertExercisesQuery(this.dataSource), entity);
    }


}
