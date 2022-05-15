package persistence.user;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.junit.jupiter.api.Test;

class UserDAOTest extends DAOTest {

    private UserDAO userDAO = new UserDAO();


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
//        IDataSet expectedDataSet = getDataSet();
//        ITable expectedTable = expectedDataSet.getTable("user");
        IDataSet databaseDataSet = getConnection().createDataSet();
        ITable actualTable = databaseDataSet.getTable("user");
//        assertEquals(expectedTable.getRowCount(), actualTable.getRowCount());
        assertEquals(1, actualTable.getRowCount());

    }



}