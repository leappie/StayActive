package persistence.user;

import entity.User;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Test;

class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO(getDataSource());


    @Test
    void testInsert() throws Exception {
        //Arrange
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("user");
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("user");


        // Act
        getSetUpOperation();
        getTearDownOperation();
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
        this.userDAO.insert(new User("testt", "1234"));

        //Assert
        assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());
    }
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


    }



}