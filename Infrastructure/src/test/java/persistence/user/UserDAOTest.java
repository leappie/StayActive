package persistence.user;

import entity.User;
import enums.Level;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import persistence.DAOTest;

import java.util.List;


/**
 * This class tests the CRUD operations for the UserDAO
 */
class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO(getDataSource());
    private String testData = "src/test/resources/user_testdata.xml";

    @Test
    void testInsert() throws Exception {
        // Arrange
        tearDown(); // empty the table user
        IDataSet databaseDataSet = getConnection().createDataSet();
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("user");
        String username1 = (String) expectedDataSet.getTable("user").getValue(0, "username"); // get row 0, column username
        String username2 = (String) expectedDataSet.getTable("user").getValue(1, "username");
        String password1 = (String) expectedDataSet.getTable("user").getValue(0, "password"); // get row 0, column password
        String password2 = (String) expectedDataSet.getTable("user").getValue(1, "password");

        // Act;
        this.userDAO.insert(new User(username1, password1));
        this.userDAO.insert(new User(username2, password2));

        // Assert
        ITable actualTable = databaseDataSet.getTable("user");
        Assertions.assertEquals(2, actualTable.getRowCount());
        Assertions.assertEquals(expectedTable.getValue(0, "username"), actualTable.getValue(0, "username"));
        tearDown();
    }

    @Test
    void testUpdate() throws Exception {
        // Arrange
        setUp(); // set up the table with the xml test user data
        IDataSet databaseDataSet = getConnection().createDataSet();
        int userId1 = (int) databaseDataSet.getTable("user").getValue(0, "id"); // get row 0, column id
        int userId2 = (int) databaseDataSet.getTable("user").getValue(1, "id");

        // Act
        this.userDAO.update(new User(userId1, "updatedUser1", "updatedPassword1", Level.HARD));
        this.userDAO.update(new User(userId2, "updatedUser2", "updatedPassword2", Level.HARD));

        //Assert
        String username1 = (String) databaseDataSet.getTable("user").getValue(0, "username"); // get row 0, column username
        String username2 = (String) databaseDataSet.getTable("user").getValue(1, "username");
        String password1 = (String) databaseDataSet.getTable("user").getValue(0, "password"); // get row 0, column password
        String password2 = (String) databaseDataSet.getTable("user").getValue(1, "password");
        Assertions.assertEquals(username1, "updatedUser1");
        Assertions.assertEquals(password1, "updatedPassword1");
        Assertions.assertEquals(username2, "updatedUser2");
        Assertions.assertEquals(password2, "updatedPassword2");
        tearDown();
    }

    @Test
    void testDelete() throws Exception {
        // Arrange
        setUp();
        IDataSet databaseDataSet = getConnection().createDataSet();
        String username = (String) databaseDataSet.getTable("user").getValue(0, "username");
        String password = (String) databaseDataSet.getTable("user").getValue(0, "password");

        // Act
        this.userDAO.delete(new User(username, password));

        //Assert
        ITable actualTable = databaseDataSet.getTable("user");
        Assertions.assertEquals(2, actualTable.getRowCount());
        tearDown();
    }


    @Test
    void testQuery() throws Exception {
        // Arrange
        setUp();
        IDataSet databaseDataSet = getConnection().createDataSet();
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("user");
        String username = (String) expectedDataSet.getTable("user").getValue(0, "username");
        String password = (String) expectedDataSet.getTable("user").getValue(0, "password");

        // Act;
        List<User> userList = this.userDAO.query(new User(username, password));

        //Assert
        Assertions.assertEquals(1, userList.size());
        Assertions.assertEquals(username, userList.get(0).getUsername());
        tearDown();
    }

    @Override
    protected String getTestData() {
        return testData;
    }
}




