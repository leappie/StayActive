package persistence.user;

import org.dbunit.DBTestCase;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import javax.sql.DataSource;

public class DAOTest extends DataSourceBasedDBTestCase {

    @Override
    protected DataSource getDataSource() {
        return null;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
//        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
//        builder.setDtdMetadata(false);
//        return builder.build(getClass().getResourceAsStream(datasetFilename));
        return null;
    }
}