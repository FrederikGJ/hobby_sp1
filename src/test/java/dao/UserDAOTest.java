package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.UserInfo;
import model.Users;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static UserDAO userDAO;


    @BeforeAll
   static void setUp() {
        userDAO = UserDAO.getInstance();
    }

    @AfterAll
    static void tearDown() {
        emf.close();
    }

    @Test
    void getInstance() {
        UserDAO instance1 = UserDAO.getInstance();
        assertNotNull(instance1);
        assertEquals(instance1, userDAO);
    }

    @Test
    void createUser() {
        Users testUser = new Users();
        Users createdUser = userDAO.createUser(testUser);
        assertNotNull(createdUser);
        assertTrue(createdUser.getUserId()>0);
    }

    @Test
    void readUser() {
        Users testUser = new Users();
        Users createdUser = userDAO.createUser(testUser);
        Users readUser = userDAO.readUser(createdUser.getUserId());
        assertNotNull(readUser);
        assertEquals(testUser.getUserId(), readUser.getUserId());

    }

    @Test
    void updateUser() {
        Users testUser = new Users();
        Users createdUser = userDAO.createUser(testUser);
        createdUser.setUserInfo(new UserInfo("updatedUser"));
        Users updatedUser = userDAO.updateUser(createdUser);
        assertNotNull(updatedUser);
        assertEquals("updatedUser", updatedUser.getUserInfo().getUserName());

    }

    @Test
    void deleteUser() {
        Users testUser = new Users();
        Users createdUser = userDAO.createUser(testUser);
        userDAO.deleteUser(createdUser.getUserId());
        Users deletedUser = userDAO.readUser(createdUser.getUserId());
        assertNull(deletedUser);

    }


}