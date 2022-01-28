package models.DAO;

import models.Cantante;
import models.DAO.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CantanteDAO implements DAO<Cantante> {

    private EntityManagerFactory emf;

    public CantanteDAO(){
        emf= Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Cantante obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select c from Cantante c where c.nombreArtistico=:nombreArtistic");
//        em.find(Cantante.class);
        query.setParameter("nombreArtistic",nombreABuscar);
        Cantante c = (Cantante) query.getSingleResult();
        em.close();
        System.out.println(c.toString());
        return c;
    }

    @Override
    public void anhadir(Cantante cantante) {
        System.out.println(cantante.toString());
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cantante);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Cantante c) {
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
    public void eliminar(Cantante t) {

    }

    @Override
    public List<Cantante> listar() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select c from Cantante c");
        List<Cantante>  listacantante = query.getResultList();
        for(Object cantante: listacantante){
            cantante.toString();
        }

        em.close();
        return listacantante;
    }

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
