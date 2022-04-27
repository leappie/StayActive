package amcode.infrastructure.persistence.sql;

import java.util.List;

public class DataStore<T> {
    public List<T> query(DatabaseQuery<T> query) {
        return null;
    }

    public void execute(DatabaseCommand<T> command, T param) {

    }

}
