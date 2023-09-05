package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.User;

public class UserDAO {
    private  EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public UserDAO() {}
    private static UserDAO userDAO = null;

    public static UserDAO getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public User createUser(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            em.close();
            return user;
        }
    }
        public User readUser(int userId){
            try(EntityManager em = emf.createEntityManager()){
                User readUser = em.find (User.class, userId);
                return readUser;
            }
        }

        public User updateUser(User user){
            try (EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                User updatedUser = em.merge(user);
                em.getTransaction().commit();
                em.close();
                return updatedUser;
            }
        }

        public void deleteUser(int userId) {
            try(EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                User user = readUser(userId);
                if(user != null){
                    em.remove(user);
                }
                em.getTransaction().commit();
            }
        }

//        public User getAllUserInformationByPhonenumber () {
//        try(EntityManager em = emf.createEntityManager()) {
//            TypedQuery<User> query = em.createQuery("SELECT u FROM User ")
//
//        }
//        }


}
