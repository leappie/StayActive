package persistence.user;

import entity.User;
import enums.Level;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import persistence.DAOTest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO(getDataSource());
    private String testData = "src/test/resources/user_testdata.xml";

    @Test
    void testInsert() throws Exception {
        /*
        INSERT
         */
        //Arrange
        DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
        IDataSet databaseDataSet = getConnection().createDataSet();

        // Act;
        long idInsert1 = this.userDAO.insert(new User("test1", "1234"));
        long idInsert2 = this.userDAO.insert(new User("test2", "1234"));
        long idInsert3 = this.userDAO.insert(new User("test3", "1234"));

        //Assert
        ITable actualTable = databaseDataSet.getTable("user");
        assertEquals(3, actualTable.getRowCount());
    }

    @Test
    void update() throws Exception {
        //Arrange
        IDataSet databaseDataSet = getConnection().createDataSet();
        User user = getUser(new User("test1", "1234"));

        // Act;
        this.userDAO.update(new User(user.getId(), "updatedUser", "updatedPassword", Level.HARD));


        //Assert
        ITable actualTable = databaseDataSet.getTable("user");
//        actualTable.
//        assertEquals(3, actualTable.getRowCount());

    }

    @Test
    void delete() {
    }


    private User getUser(User queryUser) throws Exception {
        User user = this.userDAO.query(queryUser).get(0);
        return user;
    }

    @Override
    protected String getTestData() {
        return testData;
    }
}