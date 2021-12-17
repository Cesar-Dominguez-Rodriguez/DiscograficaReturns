package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class MusicoDAO implements DAO {

    private EntityManagerFactory emf;

    public MusicoDAO(){
        emf= Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Object obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select m from Musico m where m.nombreArtistico=:nombreArtistic");
        query.setParameter("nombreArtistic",nombreABuscar);
        Musico m = (Musico) query.getSingleResult();
        em.close();
        return m;

    }

    @Override
    public void anhadir(Object objeto) {
        EntityManager em= emf.createEntityManager();
        Musico musico= (Musico) objeto;
        em.getTransaction().begin();
        em.persist(musico);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Object objeto) {
        Musico m= (Musico) objeto;
        String sentencia= "update Musico " +
                " set dni= '"+m.getDni()+"' , nombre= '"+m.getNombre()+
                "' , nombreArtistico= '"+m.getNombreArtistico()+"', salario= "+m.getSalario()+
                ", estiloMusical= '"+m.getEstiloMusical()+"', instrumento= '"+m.getInstrumento()+"' where idArtista="+m.getIdArtista();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Object> listar() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select m from Musico m");
        List<Object>  listaMusicos = query.getResultList();
        em.close();
        return listaMusicos;
    }

    @Override
    public void eliminar(String nombre) {
        String sentencia= "delete from Musico where nombre=:nombre";
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.setParameter("nombre",nombre);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

}
