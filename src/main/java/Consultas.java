import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Consultas {
    private EntityManagerFactory emf;
    public Consultas(){
        emf = Persistence.createEntityManagerFactory("default");
    }

    private void cantidadDeCanciones(){
        EntityManager em = emf.createEntityManager();




    };
}
