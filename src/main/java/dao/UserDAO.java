package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Users;

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
            try(EntityManager em = emf.createEntityManager()){
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
                if(users != null){
                    em.remove(users);
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
