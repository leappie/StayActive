package persistence.alert;

import common.interfaces.daos.IAlertDAO;
import entity.Alert;
import persistence.DataStore;
import persistence.StayActiveDataSource;
import persistence.alert.commands.DeleteAlertCommand;
import persistence.alert.commands.UpdateAlertCommand;
import persistence.alert.queries.SelectAlertQuery;

import javax.sql.DataSource;
import java.util.List;

public class AlertDAO implements IAlertDAO {
    private DataStore<Alert> dataStore = new DataStore<>();
    private DataSource dataSource;

    public AlertDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public AlertDAO() {
        this.dataSource = new StayActiveDataSource().getDataSource();
    }

    @Override
    public long update(Alert alert) {
        return this.dataStore.execute(new UpdateAlertCommand(this.dataSource), alert);
    }

    @Override
    public void delete(Alert alert) {
        this.dataStore.execute(new DeleteAlertCommand(this.dataSource), alert);
    }

    @Override
    public List<Alert> queryAll() {
        return this.dataStore.query(new SelectAlertQuery(this.dataSource));
    }


}
