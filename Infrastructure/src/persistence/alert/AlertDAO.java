package persistence.alert;

import common.interfaces.DAO;
import entity.Alert;
import persistence.DataStore;
import persistence.DatabaseCommand;
import persistence.DatabaseQuery;
import persistence.alert.commands.DeleteAlertCommand;
import persistence.alert.commands.UpdateAlertCommand;
import persistence.alert.queries.SelectAlertQuery;

import java.util.HashMap;
import java.util.List;

public class AlertDAO implements DAO<Alert> {
    private DataStore<Alert> dataStore = new DataStore<>();

    @Override
    public long insert(Alert entity) {
        // TODO:
        return 0;
    }

    @Override
    public long update(Alert entity) {
        return this.dataStore.execute(new UpdateAlertCommand(), entity);
    }

    @Override
    public long delete(Alert entity) {
        return this.dataStore.execute(new DeleteAlertCommand(), entity);
    }

    @Override
    public List<Alert> query(Alert entity) {
        return this.dataStore.query(new SelectAlertQuery(), entity);
    }

}
