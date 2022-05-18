package persistence;

import java.util.List;

/**
 * Copyright HBO ICT FONTYS: db class diagram used for the DataStore, DatabaseCommand and DatabaseQuery.
 *
 * @param <T>
 */
public class DataStore<T> {

    public List<T> query(DatabaseQuery<T> query) {
        return query.execute();
    }

    public long execute(DatabaseCommand<T> command, T param) {
        return command.execute(param);
    }

}
