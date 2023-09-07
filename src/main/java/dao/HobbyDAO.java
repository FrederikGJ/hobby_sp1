package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.Hobby;
import model.Users;

import java.util.List;
public class HobbyDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    private HobbyDAO() {}

    private static HobbyDAO hobbyDAO = null;
    public static HobbyDAO getInstance() {
        if (hobbyDAO == null) {
            hobbyDAO = new HobbyDAO();
        }
        return hobbyDAO;
    }

    public Hobby createHobby(Hobby hobby) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
            em.close();
            return hobby;
        }
    }
    public Hobby readHobby(int hobbyId){
        try(EntityManager em = emf.createEntityManager()){
            Hobby readHobby= em.find (Hobby.class, hobbyId);
            return readHobby;
        }
    }

    public Hobby updatedHobby (Hobby hobby){
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Hobby updatedHobby = em.merge(hobby);
            em.getTransaction().commit();
            em.close();
            return updatedHobby;
        }
    }

    public void deleteHobby(int hobbyId) {
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            Hobby hobby = readHobby(hobbyId);
            if(hobby != null){
                em.remove(hobby);
            }
            em.getTransaction().commit();
        }
    }


    public int getNumberOfPeopleWithHobby (String hobby) {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Users> users = em.createQuery("SELECT u FROM Users u JOIN u.hobbies h WHERE h.hobbyName = :hobby", Users.class);
            users.setParameter("hobby", hobby);
            List<Users> allUsers = users.getResultList();
            int count = 0;
            for(Users u : allUsers) {
                count = count + 1;
            }
            System.out.println(count);
            return count;
        }
    }



    public List<Hobby> getAllHobbies () {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Hobby> hobbies = em.createQuery("SELECT h FROM Hobby h", Hobby.class);
            return hobbies.getResultList();
        }
    }

    public int getNumberOfPeopleInterested(String hobby) {
        try(EntityManager em = emf.createEntityManager()) {
            TypedQuery<Hobby> hobbies = em.createQuery("SELECT h FROM Hobby h WHERE h.hobbyName = :hobby", Hobby.class);
            hobbies.setParameter("hobby", hobby);
            List<Hobby> allHobbies = hobbies.getResultList();
            int count = 0;
            for(Hobby h : allHobbies) {
                count = count + 1;
            }
            return count;
        }
    }
}
