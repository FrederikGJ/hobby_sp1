package dao;

import config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import model.User;
import model.Zipcode;

import java.util.List;

public class ZipDAO {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public ZipDAO() {}
    public List<Zipcode> getAllZip (){
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Zipcode> query = (TypedQuery<Zipcode>) em.createQuery("SELECT u.zipcode, u.cityName from Zipcode u");
            return query.getResultList();
        }

    }
}
