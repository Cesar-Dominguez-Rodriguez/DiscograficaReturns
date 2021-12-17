import controllers.Ctrl_cantante;
import controllers.Ctrl_menu;
import models.*;
import views.Vsta_Menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        Ctrl_menu ctrl= new Ctrl_menu();
        ctrl.ejecucion();
    }

    public static void pruebasdirectas() {

//        Disco d = new Disco("Eyes Wide Open");
//        Disco d2 = new Disco("Singular Act I");
//        Pista p = new Pista("Eyes Wide Open");
//        Pista p2 = new Pista("Almost Love");
//        Cantante SC = new Cantante("11111111H", "Sabrina Annlynn Carpenter", "Sabrina Carpenter", 10000, "Electro-pop", RegistroVoz.Soprano);
//        Cantante melendi = new Cantante("11111112H", "Ramón Melendi Espina", "Melendi", 50000, "pop y rumba", RegistroVoz.Baritono);
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
//        EntityManager em = emf.createEntityManager();
//        CantanteDAO cantanteDAO = new CantanteDAO();
//        d.anhadirPista(p);
//        d.anhadirPista(p2);
//        SC.anhadirDisco(d);
//        SC.anhadirDisco(d2);
//        cantanteDAO.anhadir(SC);
//        em.getTransaction().begin();
//        DiscoDAO discoDAO = new DiscoDAO();
//        discoDAO.anhadir(d);
//        em.persist(p);
//        em.getTransaction().commit();
//        emf.close();

    }
}
