package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.Category;
import model.Hobby;
import model.UserInfo;
import model.Users;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HobbyDAOTest {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static HobbyDAO hobbyDAO;

    @BeforeAll
   static  void setUp() {
        hobbyDAO = HobbyDAO.getInstance();
    }


    @AfterAll
   static  void tearDown() {
        emf.close();
    }

    @Test
    void getInstance() {
        HobbyDAO instance1 = HobbyDAO.getInstance();
        assertNotNull(instance1);
        assertEquals(instance1, hobbyDAO);
    }

    @Test
    void createHobby() {
        Hobby testHobby = new Hobby();
        testHobby.setHobbyName("TestHobby");
        testHobby.setCategory(Category.OUTDOOR);
        Hobby createdHobby = hobbyDAO.createHobby(testHobby);
        assertNotNull(createdHobby);
        assertTrue(createdHobby.getHobbyId()>0);
    }


    @Test
    void readHobby() {
        Hobby testHobby = new Hobby();
        testHobby.setHobbyName("TestHobby");
        testHobby.setCategory(Category.OUTDOOR);
        Hobby createdHobby = hobbyDAO.createHobby(testHobby);
        Hobby readHobby = hobbyDAO.readHobby(createdHobby.getHobbyId());
        assertNotNull(readHobby);
        assertEquals(testHobby.getHobbyId(), readHobby.getHobbyId());
    }

    @Test
    void updatedHobby() {
        Hobby testHobby = new Hobby();
        testHobby.setHobbyName("TestHobby");
        testHobby.setCategory(Category.OUTDOOR);
        Hobby createdHobby = hobbyDAO.createHobby(testHobby);
        createdHobby.setHobbyName("updatedHobbyName");
        Hobby updatedHobby= hobbyDAO.updatedHobby(createdHobby);
        assertNotNull(updatedHobby);
        assertEquals("updatedHobbyName", updatedHobby.getHobbyName());
    }

    @Test
    void deleteHobby() {
        Hobby testHobby = new Hobby();
        testHobby.setHobbyName("TestHobby");
        testHobby.setCategory(Category.OUTDOOR);
        Hobby createdHobby = hobbyDAO.createHobby(testHobby);
        hobbyDAO.deleteHobby(createdHobby.getHobbyId());
        Hobby deletedHobby = hobbyDAO.readHobby(createdHobby.getHobbyId());
        assertNull(deletedHobby);
    }

    @Test
    void getNumberOfPeopleWithHobby() {
        int result = hobbyDAO.getNumberOfPeopleWithHobby("Svømning");
        assertEquals(3, result);
    }

    @Test
    void getNumberOfPeopleInterested() {
        int result = hobbyDAO.getNumberOfPeopleInterested("Sove");
        assertEquals(1, result);
    }
}