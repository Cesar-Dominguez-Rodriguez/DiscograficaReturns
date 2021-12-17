package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PremioDAO implements DAO {
    private EntityManagerFactory emf;

    public PremioDAO(){
        emf= Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Object obtener(String nombreABuscar) {
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
    public void anhadir(Object objeto) {
        EntityManager em= emf.createEntityManager();
        Premio premio= (Premio) objeto;
        System.out.println(premio.toString());
        em.getTransaction().begin();
        em.persist(premio);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Object objeto) {
        Premio p= (Premio) objeto;
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
    public void actualizarCantante(Object objeto) {

    }

    @Override
    public List<Cantante> listarCantante() {
        return null;
    }

    @Override
    public List<Disco> listarDisco() {
        return null;
    }

    @Override
    public List<Pista> listarPista() {
        return null;
    }

    @Override
    public List<Premio> listarPremio() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select p from Premio p");
        List<Premio>  listaPremio = query.getResultList();
        em.close();
        return listaPremio;
    }

    @Override
    public List<Musico> listarMusico() {
        return null;
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
