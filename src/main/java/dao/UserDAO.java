package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.Contact;
import model.Users;
import model.Zipcode;
import java.util.List;

public class UserDAO {
    private  EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private static UserDAO userDAO = null;

    public UserDAO() {}

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public Users createUser(Users users) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(users);
            em.getTransaction().commit();
            em.close();
            return users;
        }
    }
        public Users readUser(int userId){
            try (EntityManager em = emf.createEntityManager()){
                Users readUsers = em.find (Users.class, userId);
                return readUsers;
            }
        }

        public Users updateUser(Users users){
            try (EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                Users updatedUsers = em.merge(users);
                em.getTransaction().commit();
                em.close();
                return updatedUsers;
            }
        }

        public void deleteUser(int userId) {
            try(EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                Users users = readUser(userId);
                if(users != null) {
                    em.remove(users);
                }
                em.getTransaction().commit();
            }
        }
    public List<Zipcode> getAllZip (){
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Zipcode> query = (TypedQuery<Zipcode>) em.createQuery("SELECT u.zipcode, u.cityName from Zipcode u");
            return query.getResultList();
        }
    }
    public List<Users> getAllUsersInCity (Zipcode zipcode){
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Users> query = (TypedQuery<Users>) em.createQuery("SELECT u from Users u where u.address.zipcode = :zipcode", Users.class );
            query.setParameter("zipcode", zipcode);
            return query.getResultList();
        }

    }
    public List<Users> getUsersWithHobby (String hobby) {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Users> users = em.createQuery("SELECT u FROM Users u JOIN u.hobbies h WHERE h.hobbyName = :hobby", Users.class);
            users.setParameter("hobby", hobby);
            System.out.println(users.getResultList());
            return users.getResultList();
        }
    }

    public Users getUserByPhone(int phonenumber) {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Users> users = em.createQuery("SELECT u FROM Users u JOIN Contact c ON c.userInfo = u.userInfo WHERE c.phonenumber = :phonenumber", Users.class);
            users.setParameter("phonenumber", phonenumber);
            System.out.println(users.getResultList());
            Users users1 = users.getSingleResult();
            return users1;
        }
    }

    public List<Contact> getAllContacts() {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Contact> contacts = em.createQuery("SELECT c FROM Contact c", Contact.class);
            return contacts.getResultList();
        }
    }

    public List<Contact> getUserContacts(Integer userId){
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Contact> contacts = em.createQuery("SELECT c FROM Contact c JOIN Users u ON u.userInfo = c.userInfo WHERE u.userId = :userId", Contact.class);
            contacts.setParameter("userId", userId);
            return contacts.getResultList();
        }
    }


}
