package models;

import models.DAO.DiscoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Consultas {
    private EntityManagerFactory emf;
    public Consultas(){
        emf = Persistence.createEntityManagerFactory("default");
    }

    public void cantidadDeCanciones(){
        EntityManager em = emf.createEntityManager();
        DiscoDAO discoDAO= new DiscoDAO();
        Query sentencia= em.createQuery("select p.nombre from Pista p where p.disco="+discoDAO.obtener("Sabrina Carpenter"));
        sentencia.executeUpdate();


    };
}
