package persistence.user;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.Test;

class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO();


    @Test
    void testInsert() throws Exception {
        //Arrange

        //Act


        //Assert
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
        //Arrange
        IDataSet expectedDataSet = getDataSet();
        ITable expectedTable = expectedDataSet.getTable("user");
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("user");

        // Act
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());

        //Assert
        assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());

    }



}