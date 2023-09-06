package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import model.Hobby;

public class HobbyDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private HobbyDAO() {}

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
}
