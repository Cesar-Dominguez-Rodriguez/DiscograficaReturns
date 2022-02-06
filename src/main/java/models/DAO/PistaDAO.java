package models.DAO;

import models.DAO.DAO;
import models.Pista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PistaDAO implements DAO<Pista> {

    private EntityManagerFactory emf;

    public PistaDAO(){
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Pista obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select p from Pista p where p.nombre=:nombre");
        query.setParameter("nombre",nombreABuscar);
        Pista p = (Pista) query.getSingleResult();
        p.toString();
        return p;
    }

    @Override
    public void anhadir(Pista pista) {
        EntityManager em= emf.createEntityManager();
        System.out.println(pista.toString());
        try {
            em.getTransaction().begin();
            em.persist(pista);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Error en añadir pista"+e.getMessage());
        }
        em.close();
    }

    @Override
    public void actualizar(Pista p) {
        /*String sentencia= "update Pista " +
                "set nombre= '"+p.getNombre()+"', disco="+p.getDisco()+
                ", artistas=  "+p.getArtistas();*/
        String sentencia= "update Pista " +
                "set nombre= '"+p.getNombre()+"', disco="+p.getDisco().getIdDisco();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Query query = em.createQuery(sentencia);
            System.out.println(sentencia);
            query.executeUpdate();
            em.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Error al actualizar pista"+e.getMessage());

        }
        em.close();
    }

    @Override
    public void eliminar(Pista pista) {

    }

    @Override
    public List<Pista> listar() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select p from Pista p");
        List<Pista>  listapista =query.getResultList();
        return listapista;
    }

    @Override
    public void eliminar(String nombre) {
        EntityManager em = emf.createEntityManager();
        String sentencia= "delete from Pista where nombre=:nombre";
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.setParameter("nombre",nombre);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
