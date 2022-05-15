package persistence;

import org.sqlite.SQLiteDataSource;
import persistence.common.Constants;

import javax.sql.DataSource;

public class StayActiveDataSource {

    public DataSource getDataSource() {
        SQLiteDataSource sqLiteDataSource = new SQLiteDataSource();
        sqLiteDataSource.setUrl(Constants.CONNECTION_STRING);
        return sqLiteDataSource;
    }

}
