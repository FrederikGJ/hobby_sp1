package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.Contact;
import model.Users;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserDAOTest {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private static UserDAO userDAO = UserDAO.getInstance();

    @Test
    void getUsersWithHobby() {
        int result = userDAO.getUsersWithHobby("Sove").size();
        assertEquals(1, result);
    }

    @Test
    void getUserByPhone() {
        Users user = userDAO.getUserByPhone(30294785);
        assertEquals(user.getUserInfo().getUserName(), "Signe");
    }

    @Test
    void getPhoneByUser() {
        Integer phonenumber = userDAO.getPhoneFromUser(8);
        assertEquals(21212121, phonenumber);
    }
}