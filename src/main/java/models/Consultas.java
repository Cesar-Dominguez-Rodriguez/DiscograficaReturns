package models;

import models.DAO.DiscoDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Consultas {
    private EntityManagerFactory emf;
    public Consultas(){
        emf = Persistence.createEntityManagerFactory("default");
    }

    public void cantidadDeCanciones(){
        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Query sentencia= em.createQuery("select p.nombre from Pista p");
            sentencia.executeUpdate();
            em.getTransaction().commit();
            List resultado = sentencia.getResultList();
            for (Object a : resultado){
                System.out.println(a);
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
        }
    };

    public void discosOrdenadosPorFecha(){
        EntityManager em = emf.createEntityManager();
        Query sentencia= em.createQuery("select d from Disco as d order by d.anhoSalida");
        sentencia.executeUpdate();
        List resultado = sentencia.getResultList();
        for (Object a : resultado){
            System.out.println(a);
        }
    }

    public void artistasPorEstilo(){

    }

    public void artistasQueMasDineroGanaronConPremios(){
        EntityManager em = emf.createEntityManager();
        Query sentencia= em.createQuery("select p.artistas from Premio p order by p.dinero");
        sentencia.executeUpdate();
        List resultado = sentencia.getResultList();
        for (Object a : resultado){
            System.out.println(a);
        }
    }

    public void agruparArtistasPorRegistroDeVoz(){
        EntityManager em = emf.createEntityManager();
        Query sentencia= em.createQuery("select c.nombreArtistico from Cantante c order by c.voz");
        sentencia.executeUpdate();
        List resultado = sentencia.getResultList();
        for (Object a : resultado){
            System.out.println(a);
        }


    }
}
