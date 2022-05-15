package persistence.user;

import entity.User;
import org.dbunit.*;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sqlite.SQLiteDataSource;
import org.xml.sax.InputSource;
import persistence.StayActiveDataSource;

import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;

class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO();

    public UserDAOTest(String datasetFilename) {
        super("data.xml");
    }

//    @Test
//    void insert() {
//        //Arrange
//        //Act
//        //Assert
//    }
//
//    @Test
//    void update() {
//    }
//
//    @Test
//    void delete() {
//    }

    @Test
    void testQuery() throws Exception {
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("user");
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("user");
        assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());
    }



}