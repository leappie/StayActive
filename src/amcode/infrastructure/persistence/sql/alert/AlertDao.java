package amcode.infrastructure.persistence.sql.alert;

import amcode.application.common.interfaces.daos.IAlertDao;
import amcode.domain.entity.Alert;
import amcode.infrastructure.persistence.sql.DatabaseCommand;
import amcode.infrastructure.persistence.sql.DatabaseQuery;
import amcode.infrastructure.persistence.sql.alert.commands.DeleteAlertCommand;
import amcode.infrastructure.persistence.sql.alert.commands.UpdateAlertCommand;
import amcode.infrastructure.persistence.sql.alert.queries.SelectAlertQuery;

import java.util.HashMap;
import java.util.List;

public class AlertDao implements IAlertDao {
    private HashMap<String, DatabaseQuery<Alert>> alertQueryList;
    private HashMap<String, DatabaseCommand<Alert>> alertCommandList;

    public AlertDao( HashMap<String, DatabaseQuery<Alert>> alertQueryList,
                    HashMap<String, DatabaseCommand<Alert>> alertCommandList) {
        this.alertQueryList = alertQueryList;
        this.alertCommandList = alertCommandList;
    }

    public AlertDao() {
        /*
        For convenience
         */
        this.alertQueryList = new HashMap<>();
        this.alertQueryList.put("getAlerts", new SelectAlertQuery());

        this.alertCommandList = new HashMap<>();
        this.alertCommandList.put("update", new UpdateAlertCommand());
        this.alertCommandList.put("delete", new DeleteAlertCommand());
    }


    @Override
    public long insertUserAlert(Alert alert) {
        return -1;
    }

    @Override
    public long updateAlert(Alert alert) {
        return this.alertCommandList.get("update").execute(alert);
    }

    @Override
    public long deleteAlert(Alert alert) {
        return this.alertCommandList.get("delete").execute(alert);
    }

    @Override
    public List<Alert> getAlerts(Alert alert) {
        return null;
    }
}
