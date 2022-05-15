package persistence.alert;

import common.interfaces.DAO;
import entity.Alert;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.alert.commands.DeleteAlertCommand;
import persistence.alert.commands.UpdateAlertCommand;
import persistence.alert.queries.SelectAlertQuery;

import javax.sql.DataSource;
import java.util.List;

public class AlertDAO implements DAO<Alert> {
    private DataStore<Alert> dataStore = new DataStore<>();
    private DataSource dataSource;

    public AlertDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AlertDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long insert(Alert entity) {
        // TODO:
        return 0;
    }

    @Override
    public long update(Alert entity) {
        return this.dataStore.execute(new UpdateAlertCommand(this.dataSource), entity);
    }

    @Override
    public long delete(Alert entity) {
        return this.dataStore.execute(new DeleteAlertCommand(this.dataSource), entity);
    }

    @Override
    public List<Alert> query(Alert entity) {
        return this.dataStore.query(new SelectAlertQuery(this.dataSource), entity);
    }

}
