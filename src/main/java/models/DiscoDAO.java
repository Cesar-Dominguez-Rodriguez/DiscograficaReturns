package models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class DiscoDAO implements DAO<Disco>{

    private EntityManagerFactory emf;

    public DiscoDAO() {
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public Disco obtener(String nombreABuscar) {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select d from Disco d where d.nombre=:nombre");
        query.setParameter("nombre",nombreABuscar);
        Disco d = (Disco) query.getSingleResult();
        d.toString();
        em.close();
        return d;
    }

    @Override
    public void anhadir(Disco objeto) {
        EntityManager em= emf.createEntityManager();
        Disco disco= (Disco) objeto;
        System.out.println(disco.toString());
        em.getTransaction().begin();
        em.persist(disco);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void actualizar(Disco d) {
        String sentencia= "update Disco " +
                "set nombre= '"+d.getNombre()+"', artista= "+d.getArtista()+", pistas="+d.getPistas();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        System.out.println(sentencia);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Disco t) {

    }

    @Override
    public List<Disco> listar() {
        EntityManager em = emf.createEntityManager();
        Query query= em.createQuery("select d from Disco d");
        List<Disco>  listadisco = query.getResultList();
        em.close();
        return listadisco;
    }

    @Override
    public void eliminar(String nombre) {
        EntityManager em = emf.createEntityManager();
        String sentencia= "delete from Disco where nombre=:nombre";
        em.getTransaction().begin();
        Query query= em.createQuery(sentencia);
        query.setParameter("nombre",nombre);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    public void meterDiscoEnCAntante(Cantante cantante, Disco disco){
        EntityManager em= emf.createEntityManager();
        cantante.anhadirDisco(disco);
        disco.setArtista(cantante);
        String sentenciaC = "update Cantante set discos="+cantante.getDiscos();
        String sentenciaD = "update Disco set artista="+disco.getArtista();
        Query queryC = em.createQuery(sentenciaC);
        Query queryD = em.createQuery(sentenciaD);
        em.getTransaction().begin();
        queryC.executeUpdate();
        queryD.executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}