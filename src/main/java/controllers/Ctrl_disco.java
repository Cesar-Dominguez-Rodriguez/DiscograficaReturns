package controllers;

import models.*;
import views.Vsta_cantante;
import views.Vsta_disco;
import views.Vsta_musico;
import views.Vsta_pista;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_disco {

    private Vsta_disco vista;

    public Ctrl_disco() {
        vista = new Vsta_disco();
    }

    public void ctrl(int option) {
        Boolean ejecucion = true;
        while (ejecucion) {
            switch (option) {
                case 1:
                    anhadirDisco();
                    ejecucion = false;
                    break;
                case 2:
                    modificarDisco();
                    ejecucion = false;
                    break;
                case 3:
                    listarDisco();
                    ejecucion = false;
                    break;
                case 4:
                    eliminarDisco();
                    ejecucion = false;
                    break;
                case 0:
                    ejecucion = false;
                    break;
            }
        }
    }

    public void anhadirDisco() {
        CantanteDAO cantanteDAO= new CantanteDAO();
        Disco d = new Disco(
                vista.pedirNombre(),
                vista.pedirAnhoSalida(),
                vista.pedirNumCanciones(),
                (Artista) cantanteDAO.obtener("Sabrina Carpenter")
        );

//        Pista pista= new Pista(new Vsta_pista().pedirNombre(),new Vsta_pista().pedirDuracion(),new Vsta_pista().pedirLetra());
//        PistaDAO pistaDAO= new PistaDAO();
//        new DiscoDAO().anhadir(d);
//        pista.setDisco(d);
//        d.getPistas().add(pista);
//        pistaDAO.anhadir(pista);
//        for(Pista p: d.getPistas()){
//            p.setDisco(d);
//            pistaDAO.actualizar(p);
//        }
        new DiscoDAO().anhadir(d);
    }

    public Pista anhadirPistaADisco(){

        PistaDAO pistaDAO= new PistaDAO();
        Pista pista= (Pista) pistaDAO.obtener(new Vsta_pista().pedirNombre());
        return pista;
    }

    public void modificarDisco() {
        DiscoDAO discoDAO = new DiscoDAO();
        Disco d = (Disco) discoDAO.obtener(vista.pedirNombre());
        modificarAtributoDisco(d);
        discoDAO.actualizar(d);
    }

    public void listarDisco() {
        DiscoDAO discoDAO = new DiscoDAO();
        List<Disco> listadisco = new ArrayList<>();
        List<Object> listaobjeto = discoDAO.listar();
        for (Object o : listaobjeto) {
            Disco d = (Disco) o;
            listadisco.add(d);
            System.out.println(d.toString());
        }

    }

    public void eliminarDisco() {
        DiscoDAO discoDAO = new DiscoDAO();
        discoDAO.eliminar(vista.pedirNombre());
    }

    private void modificarAtributoDisco(Disco disco) {
        CantanteDAO cantanteDAO = new CantanteDAO();
        MusicoDAO musicoDAO = new MusicoDAO();
        Vsta_cantante vsta_cantante = new Vsta_cantante();
        Vsta_musico vsta_musico = new Vsta_musico();
        DiscoDAO discoDAO= new DiscoDAO();
        switch (vista.modificarAtributo()) {
            case 1:
                disco.setNombre(vista.pedirNombre());
                break;
            case 2:
                if (vista.accionArtista() == 1) {
                    if (vista.tipoDeArtista() == 1) {
                        Cantante cantante = (Cantante) cantanteDAO.obtener(vsta_cantante.pedirNombreArtistico());
                        discoDAO.meterDiscoEnCAntante(cantante,disco);
//                        disco.setArtista(cantante);
//                        cantante.getDiscos().add(disco);
                    } else if (vista.tipoDeArtista() == 2) {
                        Musico musico= (Musico) musicoDAO.obtener(vsta_musico.pedirNombreArtistico());
//                        disco.setArtista(musico);
//                        musico.getDiscos().add(disco);
                    }else if (vista.accionArtista() == 0) {
                    }
                } else if (vista.accionArtista() == 2) {
                    disco.setArtista(null);
                }
                break;
            case 0:
                break;
        }
    }
}
