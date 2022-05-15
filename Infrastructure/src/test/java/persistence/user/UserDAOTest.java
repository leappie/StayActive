package persistence.user;

import entity.User;
import enums.Level;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import persistence.DAOTest;

import java.util.List;

class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO(getDataSource());
    private String testData = "src/test/resources/user_testdata.xml";

    @Test
    void testCRUD() throws Exception {
        /*
        INSERT
         */
        //Arrange
        DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
        IDataSet databaseDataSet = getConnection().createDataSet();

        // Act;
        long idInsert1 = this.userDAO.insert(new User("test1", "1234"));
        long idInsert2 = this.userDAO.insert(new User("test2", "1234"));

        //Assert
        ITable actualTable = databaseDataSet.getTable("user");
        Assertions.assertEquals(2, actualTable.getRowCount());

        /*
        UPDATE
         */
        //Arrange
        // Act;
        this.userDAO.update(new User((int) idInsert1, "updatedUser1", "updatedPassword1", Level.HARD));
        this.userDAO.update(new User((int) idInsert2, "updatedUser2", "updatedPassword2", Level.HARD));

        //Assert
        String username1 = (String) databaseDataSet.getTable("user").getValue(0, "username"); // get row 0, column username
        String username2 = (String) databaseDataSet.getTable("user").getValue(1, "username"); // get row 1, column username
        String password1 = (String) databaseDataSet.getTable("user").getValue(0, "password"); // get row 0, column password
        String password2 = (String) databaseDataSet.getTable("user").getValue(1, "password"); // get row 1, column password
        Assertions.assertEquals(username1, "updatedUser1");
        Assertions.assertEquals(password1, "updatedPassword1");
        Assertions.assertEquals(username2, "updatedUser2");
        Assertions.assertEquals(password2, "updatedPassword2");

        /*
        DELETE
         */
        //Arrange
        // Act;
        this.userDAO.delete(new User("updatedUser1", "updatedPassword1"));

        //Assert
        actualTable = databaseDataSet.getTable("user");
        Assertions.assertEquals(1, actualTable.getRowCount());


        /*
        Query
         */
        //Arrange
        // Act;
        List<User> userList = this.userDAO.query(new User("updatedUser2", "updatedPassword2"));

        //Assert
        Assertions.assertEquals(1, userList.size());
        Assertions.assertEquals("updatedUser2", userList.get(0).getUsername());
    }

    @Override
    protected String getTestData() {
        return testData;
    }
}