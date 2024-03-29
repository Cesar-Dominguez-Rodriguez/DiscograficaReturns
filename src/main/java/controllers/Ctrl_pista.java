package controllers;

import models.*;
import models.DAO.CantanteDAO;
import models.DAO.DiscoDAO;
import models.DAO.MusicoDAO;
import models.DAO.PistaDAO;
import views.Vsta_cantante;
import views.Vsta_disco;
import views.Vsta_musico;
import views.Vsta_pista;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Ctrl_pista {

    private Vsta_pista vista;
    private PistaDAO pistaDAO;
    private Vsta_disco vsta_disco;

    public Ctrl_pista() {
        vista = new Vsta_pista();
        pistaDAO = new PistaDAO();
        vsta_disco = new Vsta_disco();
    }

    public void ctrl(int option) {
        Boolean ejecucion = true;
        while (ejecucion) {
            switch (option) {
                case 1:
                    anhadirPista();
                    ejecucion = false;
                    break;
                case 2:
                    modificarPista();
                    ejecucion = false;
                    break;
                case 3:
                    listarPista();
                    ejecucion = false;
                    break;
                case 4:
                    eliminarPista();
                    ejecucion = false;
                    break;
                case 0:
                    ejecucion = false;
                    break;
            }
        }
    }

    public void anhadirPista() {
        Pista p = new Pista(
                vista.pedirNombre(),
                vista.pedirDuracion(),
                vista.pedirLetra()
        );
        System.out.println(p);
        pistaDAO.anhadir(p);
    }

    public void modificarPista() {
        PistaDAO pistaDAO = new PistaDAO();
        Pista p = pistaDAO.obtener(vista.pedirNombre());
        modificarAtributoPista(p);
        pistaDAO.actualizar(p);
    }

    public void listarPista() {
        PistaDAO pistaDAO = new PistaDAO();
        List<Pista> listapista = pistaDAO.listar();
        try {
            for (Pista p : listapista) {
                System.out.println(p.toString());
            }
        } catch (Exception e) {
            System.out.println("Error al listar pistas"+e.getMessage()+" causa:"+e.getCause());
        }
    }

    public void eliminarPista() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        PistaDAO pistaDAO = new PistaDAO();
        pistaDAO.eliminar(vista.pedirNombre());
    }

    private void modificarAtributoPista(Pista pista) {
        CantanteDAO cantanteDAO = new CantanteDAO();
        MusicoDAO musicoDAO = new MusicoDAO();
        DiscoDAO discoDAO = new DiscoDAO();
        Vsta_cantante vsta_cantante = new Vsta_cantante();
        Vsta_musico vsta_musico = new Vsta_musico();
        switch (vista.modificarAtributo()) {
            case 1:
                    pista.setNombre(vista.pedirNombre());
                break;
            case 2:
                int opcionActionDisco = vista.actionDisco();
                if (opcionActionDisco == 0) {

                } else if (opcionActionDisco == 1) {
                    pista.setDisco(discoDAO.obtener(vsta_disco.pedirNombre()));

                } else if (opcionActionDisco == 2) {
                    pista.setDisco(null);

                }
                break;
            case 3:
                if (vista.actionArtista() == 0) {


                } else if (vista.actionArtista() == 1) {
                    if (vista.tipoDeArtista() == 1) {
//                        Cantante cantante = cantanteDAO.obtener(vsta_cantante.pedirNombreArtistico());
//                        pista.getArtistas().add(cantante);
//                        cantante.getPistas().add(pista);
                    } else if (vista.tipoDeArtista() == 2) {
//                        Musico musico= musicoDAO.obtener(vsta_musico.pedirNombreArtistico());
//                        pista.getArtistas().add(musico);
//                        musico.getPistas().add(pista);
                    }

                } else if (vista.actionArtista() == 2) {
                    ////// Problema /////
//                 pista.getArtistas().remove(vsta_cantante);

                }
                break;
            case 0:
                break;
        }
    }

}
