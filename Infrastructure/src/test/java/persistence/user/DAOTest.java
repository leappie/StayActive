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

public class DAOTest extends DataSourceBasedDBTestCase {

    private static final String XML_TEST_DATA = "D:\\GitHubRep\\StayActive\\Infrastructure\\src\\test\\resources\\data.xml";

    @Override
    protected DataSource getDataSource() {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:D:\\GitHubRep\\StayActive\\Infrastructure\\src\\test\\resources\\stayactive_testdb.db");
        return dataSource;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
//        return new FlatXmlDataSetBuilder().build(getClass().getClassLoader()
//                .getResourceAsStream(XML_TEST_DATA));
        return null;
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