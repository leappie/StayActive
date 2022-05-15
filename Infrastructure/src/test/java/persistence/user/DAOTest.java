package persistence.user;

import org.dbunit.DBTestCase;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;

public class DAOTest extends DataSourceBasedDBTestCase {

    private static final String XML_TEST_DATA = "src/test/resources/data.xml";

    @Override
    protected DataSource getDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:src/test/resources/stayactive_testdb.db");
        return dataSource;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream(XML_TEST_DATA));
    }

    @Override
    protected DatabaseOperation getSetUpOperation() {
        return DatabaseOperation.REFRESH;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() {
        return DatabaseOperation.DELETE_ALL;
    }
}