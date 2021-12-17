package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PistaDAO implements DAO {

    private EntityManagerFactory emf;

    public PistaDAO(){
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Object obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select p from Pista p where p.nombre=:nombre");
        query.setParameter("nombre",nombreABuscar);
        Pista p = (Pista) query.getSingleResult();
        p.toString();
        return p;
    }

    @Override
    public void anhadir(Object objeto) {
        EntityManager em= emf.createEntityManager();
        Pista pista= (Pista) objeto;
        System.out.println(pista.toString());
        em.getTransaction().begin();
        em.persist(pista);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Object objeto) {
        Pista p= (Pista) objeto;
        String sentencia= "update Pista " +
                "set nombre= '"+p.getNombre()+"', disco="+p.getDisco()+
                ", artistas=  "+p.getArtistas();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        System.out.println(sentencia);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Object> listar() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select p from Pista p");
        List<Object>  listapista =query.getResultList();
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
