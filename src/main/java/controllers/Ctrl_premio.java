package controllers;

import models.Artista;
import models.DAO.CantanteDAO;
import models.DAO.MusicoDAO;
import models.Premio;
import models.DAO.PremioDAO;
import views.Vsta_cantante;
import views.Vsta_musico;
import views.Vsta_premio;

import java.util.List;

public class Ctrl_premio {

    private Vsta_premio vista;
    private Vsta_cantante vsta_cantante;
    private Vsta_musico vsta_musico;
    private CantanteDAO cantanteDAO;
    private MusicoDAO musicoDAO;

    public Ctrl_premio() {
        vista = new Vsta_premio();
        vsta_cantante = new Vsta_cantante();
        vsta_musico = new Vsta_musico();
        cantanteDAO = new CantanteDAO();
        musicoDAO = new MusicoDAO();

    }

    public void ctrl(int option) {
        Boolean ejecucion = true;
        while (ejecucion) {
            switch (option) {
                case 1:
                    anhadirPremio();
                    ejecucion = false;
                    break;
                case 2:
                    modificarPremio();
                    ejecucion = false;
                    break;
                case 3:
                    listarPremio();
                    ejecucion = false;
                    break;
                case 4:
                    eliminarPremio();
                    ejecucion = false;
                    break;
                case 0:
                    ejecucion = false;
                    break;
            }
        }
    }

    public void anhadirPremio() {
        Premio p = new Premio(
                vista.pedirNombre(),
                vista.pedirDinero(),
                vista.pedirMaterial(),
                vista.pedirAnhoFundacion()
        );
        System.out.println("Premio - anhadirPremio ->"+p);
        PremioDAO premioDAO = new PremioDAO();
        premioDAO.anhadir(p);
    }

    public void modificarPremio() {
        PremioDAO premioDAO = new PremioDAO();
        Premio p = premioDAO.obtener(vista.pedirNombre());
        modificarAtributoPremio(p);
        premioDAO.actualizar(p);
    }

    public void listarPremio() {
        PremioDAO premioDAO = new PremioDAO();
        List<Premio> listaPremio = premioDAO.listar();
        for (Premio p : listaPremio){
            System.out.println(p.toString());
        }

    }

    public void eliminarPremio() {
        PremioDAO premioDAO = new PremioDAO();
        premioDAO.eliminar(vista.pedirNombre());
    }

    private void modificarAtributoPremio(Premio premio) {
        switch (vista.modificarAtributo()) {
            case 1:
                premio.setNombre(vista.pedirNombre());
                break;
            case 2:
                premio.setDinero(vista.pedirDinero());
                break;
            case 3:
                int opcion= vista.tipoDeArtista();
                switch(opcion){
                    case 1:
                        System.out.println(premio.getArtistas());
                        List<Artista> cantantes= premio.getArtistas();
                        cantantes.add(cantanteDAO.obtener(vsta_cantante.pedirNombreArtistico()));
                        premio.setArtistas(cantantes);
                        break;
                    case 2:
                        List<Artista> musicos= premio.getArtistas();
                        musicos.add(musicoDAO.obtener(vsta_musico.pedirNombreArtistico()));
                        premio.setArtistas(musicos);
                    break;
                }

                break;
            case 0:
                break;
        }
    }

}