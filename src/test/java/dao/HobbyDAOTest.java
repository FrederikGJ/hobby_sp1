package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HobbyDAOTest {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static HobbyDAO hobbyDAO = HobbyDAO.getInstance();

    private static UserDAO userDAO = UserDAO.getInstance();

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