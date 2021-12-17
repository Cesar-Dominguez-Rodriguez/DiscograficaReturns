package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CantanteDAO implements DAO{

    private EntityManagerFactory emf;

    public CantanteDAO(){
        emf= Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Object obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select c from Cantante c where c.nombreArtistico=:nombreArtistic");
        query.setParameter("nombreArtistic",nombreABuscar);
        Cantante c = (Cantante) query.getSingleResult();
        em.close();
        return c;
    }

    @Override
    public void anhadir(Object objeto) {
        Cantante cantante= (Cantante) objeto;
        System.out.println(cantante.toString());
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cantante);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Object objeto) {
        Cantante c= (Cantante) objeto;
        String sentencia= "update Cantante " +
                "set dni= '"+c.getDni()+"', nombre= '"+c.getNombre()+
                "', nombreArtistico= '"+c.getNombreArtistico()+"', salario= "+c.getSalario()+
                ", estiloMusical= '"+c.getEstiloMusical()+"' where idArtista ="+c.getIdArtista();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizarCantante(Object objeto) {

    }

    @Override
    public List<Cantante> listarCantante() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select c from Cantante c");
        List<Cantante>  listacantante = query.getResultList();
        for(Object cantante: listacantante){
            cantante.toString();
        }

        em.close();
        return listacantante;
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
        return null;
    }

    @Override
    public List<Musico> listarMusico() {
        return null;
    }

    @Override
    public void eliminar(String nombre) {
        String sentencia= "delete from Cantante where nombre=:nombre";
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.setParameter("nombre",nombre);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
