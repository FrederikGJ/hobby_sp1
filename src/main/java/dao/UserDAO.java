package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.User;
import model.Zipcode;

import java.util.List;

public class UserDAO {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public UserDAO() {}

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
                User readUser= em.find (User.class, userId);
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

        public List<User> getUsersByZip (Integer zipID){
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<User> query = (TypedQuery<User>) em.createQuery("SELECT u from User u WHERE u.address.zipcode = " +zipID);
            return query.getResultList();
        }

        }



}
