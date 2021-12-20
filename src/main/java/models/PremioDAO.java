package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PremioDAO implements DAO<Premio>{
    private EntityManagerFactory emf;

    public PremioDAO(){
        emf= Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Premio obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery("select p from Premio p where p.nombre=:nombre");
        query.setParameter("nombre",nombreABuscar);
        Premio p = (Premio) query.getSingleResult();
        p.toString();
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public void anhadir(Premio premio) {
        EntityManager em= emf.createEntityManager();
        System.out.println(premio.toString());
        em.getTransaction().begin();
        em.persist(premio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Premio p) {
        String sentencia= "update Premio " +
                "set nombre= '"+p.getNombre()+
                "', dinero= "+p.getDinero()+", artistas= "+p.getArtistas();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        System.out.println(sentencia);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Premio t) {

    }

    @Override
    public List<Premio> listar() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select p from Premio p");
        List<Premio>  listaPremio = query.getResultList();
        em.close();
        return listaPremio;
    }

    @Override
    public void eliminar(String nombre) {
        EntityManager em = emf.createEntityManager();
        String sentencia= "delete from Premio where nombre=:nombre";
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.setParameter("nombre",nombre);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
