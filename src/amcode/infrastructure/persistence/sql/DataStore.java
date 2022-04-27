package amcode.infrastructure.persistence.sql;

import java.util.List;

public class DataStore<T> {
    protected static final String DB_NAME = "stayactive_db.db";
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + DB_NAME;

    public List<T> query(DatabaseQuery<T> query, T param) {
        return query.execute(param);
    }

    public long execute(DatabaseCommand<T> command, T param) {
        return command.execute(param);
    }

}
