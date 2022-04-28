package amcode.infrastructure.persistence.sql.alertexercise;

import amcode.application.common.interfaces.daos.IAlertExerciseDao;
import amcode.domain.entity.Alert;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.alertexercise.commands.DeleteAlertExerciseCommand;
import amcode.infrastructure.persistence.sql.alertexercise.commands.InsertAlertExerciseCommand;
import amcode.infrastructure.persistence.sql.alertexercise.commands.UpdateAlertExerciseCommand;
import amcode.infrastructure.persistence.sql.alertexercise.queries.SelectAlertExercisesQuery;

import java.util.HashMap;
import java.util.List;

public class AlertExerciseDao implements IAlertExerciseDao {
    private HashMap<String, DatabaseQuery<Alert>> alertQueryList;
    private HashMap<String, DatabaseCommand<Alert>> alertCommandList;

    public AlertExerciseDao(HashMap<String, DatabaseQuery<Alert>> alertQueryList,
                     HashMap<String, DatabaseCommand<Alert>> alertCommandList) {
        this.alertQueryList = alertQueryList;
        this.alertCommandList = alertCommandList;
    }

    public AlertExerciseDao() {
        /*
        For convenience
         */
        this.alertQueryList = new HashMap<>();
        this.alertQueryList.put("getAlertExercises", new SelectAlertExercisesQuery());

        this.alertCommandList = new HashMap<>();
        this.alertCommandList.put("update", new UpdateAlertExerciseCommand());
        this.alertCommandList.put("delete", new DeleteAlertExerciseCommand());
        this.alertCommandList.put("insert", new InsertAlertExerciseCommand());

    }


    @Override
    public long insertAlertExercise(Alert alert) {
        return this.alertCommandList.get("insert").execute(alert);
    }

    @Override
    public long updateAlertExercise(Alert alert) {
        return this.alertCommandList.get("update").execute(alert);
    }

    @Override
    public long deleteAlertExercise(Alert alert) {
        return this.alertCommandList.get("delete").execute(alert);
    }

    @Override
    public Alert getAlertExercises(Alert alert) {
        List<Alert> alertList = this.alertQueryList.get("getAlertExercises").execute(alert);
        return alertList.get(alertList.size() - 1);
    }
}
