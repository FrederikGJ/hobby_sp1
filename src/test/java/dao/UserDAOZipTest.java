package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOZipTest {
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
    void getAllZip() {

        Users u1 = new Users();
        UserInfo ui1 = new UserInfo("Signe", LocalDateTime.now(), LocalDateTime.now());
        Contact c1 = new Contact(30294785);
        Hobby h1 = new Hobby("Svømning", Category.INDOOR);
        Address a1 = new Address("Mosevej", 3);
        Zipcode z1 = new Zipcode(3400, "Hillerød", "Region Nordsjælland", "Hillerød Kommune");

        userDAO.createUser(u1); // User is created and persisted
        u1.addUserInfo(ui1); // add UserInfo to User
        ui1.addContact(c1); // add Contact to UserInfo
        u1.addHobbies(h1); // add Hobby to User
        u1.addAddress(a1); // add Address to User
        a1.addZipcode(z1); // add Zipcode to Address
        userDAO.updateUser(u1); // update the User so the changes are merges to the DB

        Users u2 = new Users();
        UserInfo ui2 = new UserInfo("Herman", LocalDateTime.now(), LocalDateTime.now());
        Contact c2 = new Contact(67489845);
        Hobby h2 = new Hobby("Skak", Category.INDOOR);
        Address a2 = new Address("Farveladevej", 78);

        userDAO.createUser(u2); // User is created and persisted
        u2.addUserInfo(ui2); // add UserInfo to User
        ui2.addContact(c2); // add Contact to UserInfo
        u2.addHobbies(h2); // add Hobby to User
        u2.addAddress(a2); // add Address to User
        a2.addZipcode(z1); // add Zipcode to Address
        userDAO.updateUser(u2); // update the User so the changes are merges to the DB

        Users u3 = new Users();
        UserInfo ui3 = new UserInfo("Mads", LocalDateTime.now(), LocalDateTime.now());
        Contact c3 = new Contact(65789347);
        Hobby h3 = new Hobby("Madlavning", Category.INDOOR);
        Address a3 = new Address("Farumvej", 7);
        Zipcode z3 = new Zipcode(3520, "Farum", "Region Nordsjælland", "Furesø Kommune");

        userDAO.createUser(u3); // User is created and persisted
        u3.addUserInfo(ui3); // add UserInfo to User
        ui3.addContact(c3); // add Contact to UserInfo
        u3.addHobbies(h3); // add Hobby to User
        u3.addAddress(a3); // add Address to User
        a3.addZipcode(z3); // add Zipcode to Address
        userDAO.updateUser(u3); // update the User so the changes are merges to the DB
        List<Zipcode> usersList = new ArrayList<>();
        usersList = userDAO.getAllZip();
        assertEquals(2,usersList.size());

    }

    @Test
    void getAllUsersInCity() {
        Users u1 = new Users();
        UserInfo ui1 = new UserInfo("Signe", LocalDateTime.now(), LocalDateTime.now());
        Contact c1 = new Contact(30294785);
        Hobby h1 = new Hobby("Svømning", Category.INDOOR);
        Address a1 = new Address("Mosevej", 3);
        Zipcode z1 = new Zipcode(3400, "Hillerød", "Region Nordsjælland", "Hillerød Kommune");

        userDAO.createUser(u1); // User is created and persisted
        u1.addUserInfo(ui1); // add UserInfo to User
        ui1.addContact(c1); // add Contact to UserInfo
        u1.addHobbies(h1); // add Hobby to User
        u1.addAddress(a1); // add Address to User
        a1.addZipcode(z1); // add Zipcode to Address
        userDAO.updateUser(u1); // update the User so the changes are merges to the DB

        Users u2 = new Users();
        UserInfo ui2 = new UserInfo("Herman", LocalDateTime.now(), LocalDateTime.now());
        Contact c2 = new Contact(67489845);
        Hobby h2 = new Hobby("Skak", Category.INDOOR);
        Address a2 = new Address("Farveladevej", 78);

        userDAO.createUser(u2); // User is created and persisted
        u2.addUserInfo(ui2); // add UserInfo to User
        ui2.addContact(c2); // add Contact to UserInfo
        u2.addHobbies(h2); // add Hobby to User
        u2.addAddress(a2); // add Address to User
        a2.addZipcode(z1); // add Zipcode to Address
        userDAO.updateUser(u2); // update the User so the changes are merges to the DB

        Users u3 = new Users();
        UserInfo ui3 = new UserInfo("Mads", LocalDateTime.now(), LocalDateTime.now());
        Contact c3 = new Contact(65789347);
        Hobby h3 = new Hobby("Madlavning", Category.INDOOR);
        Address a3 = new Address("Farumvej", 7);
        Zipcode z3 = new Zipcode(3520, "Farum", "Region Nordsjælland", "Furesø Kommune");

        userDAO.createUser(u3); // User is created and persisted
        u3.addUserInfo(ui3); // add UserInfo to User
        ui3.addContact(c3); // add Contact to UserInfo
        u3.addHobbies(h3); // add Hobby to User
        u3.addAddress(a3); // add Address to User
        a3.addZipcode(z3); // add Zipcode to Address
        userDAO.updateUser(u3); // update the User so the changes are merges to the DB

       List<Users> usersList = new ArrayList<>();
       usersList = userDAO.getAllUsersInCity(z1);
       assertEquals(2,usersList.size());








    }
}