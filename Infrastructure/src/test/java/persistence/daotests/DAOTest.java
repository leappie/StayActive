package persistence.daotests;

import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;

public abstract class DAOTest extends DataSourceBasedDBTestCase {

    @Override
    protected DataSource getDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:src/test/resources/stayactive_testdb.db");
        return dataSource;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(getTestData()));
    }

    @Override
    protected DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.DELETE_ALL;
    }

    protected abstract String getTestData();
}

