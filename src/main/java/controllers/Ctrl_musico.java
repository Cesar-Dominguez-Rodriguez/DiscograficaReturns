package controllers;

import models.*;
import models.DAO.MusicoDAO;
import models.DAO.PremioDAO;
import views.Vsta_Menu;
import views.Vsta_musico;
import views.Vsta_premio;

import java.util.List;

public class Ctrl_musico {

    private Vsta_musico vista;
    private Vsta_premio vista_premio;
    private Vsta_Menu vista_menu;

    public Ctrl_musico() {
        vista = new Vsta_musico();
        vista_menu = new Vsta_Menu();
        vista_premio = new Vsta_premio();

    }

    public void ctrl(int option) {
        Boolean ejecucion = true;
        while (ejecucion) {
            switch (option) {
                case 1:
                    anhadirMusico();
                    ejecucion = false;
                    break;
                case 2:
                    modificarMusico();
                    ejecucion = false;
                    break;
                case 3:
                    listarMusico();
                    ejecucion = false;
                    break;
                case 4:
                    eliminarMusico();
                    ejecucion = false;
                    break;
                case 0:
                    ejecucion = false;
                    break;
            }
        }
    }

    public void anhadirMusico() {
        Musico m = new Musico(
                vista.pedirDNI(),
                vista.pedirNombre(),
                vista.pedirNombreArtistico(),
                vista.pedirSalario(),
                vista.pedirEstilo(),
                vista.pedirInstrumento()
        );
        System.out.println(m.toString());
        MusicoDAO musicoDAO = new MusicoDAO();
        musicoDAO.anhadir(m);
    }

    public void modificarMusico() {
        MusicoDAO musicoDAO = new MusicoDAO();
        Musico m = musicoDAO.obtener(vista.pedirNombreArtistico());
        modificarAtributoMusico(m);
        musicoDAO.actualizar(m);
    }

    public void listarMusico() {
        MusicoDAO musicoDAO = new MusicoDAO();
        List<Musico> listamusico = musicoDAO.listar();
        for (Musico m : listamusico){
            System.out.println(m.toString());
        }
    }

    public void eliminarMusico() {
        MusicoDAO musicoDAO = new MusicoDAO();
        musicoDAO.eliminar(vista.pedirNombre());
    }

    private void modificarAtributoMusico(Musico musico) {
        switch (vista.modificarAtributo()) {
            case 1:
                musico.setDni(vista.pedirDNI());
                break;
            case 2:
                musico.setNombre(vista.pedirNombre());
                break;
            case 3:
                musico.setNombreArtistico(vista.pedirNombreArtistico());
                break;
            case 4:
                musico.setSalario(vista.pedirSalario());
                break;
            case 5:
                musico.setEstiloMusical(vista.pedirEstilo());
                break;
            case 6:
                musico.setInstrumento(vista.pedirInstrumento());
                break;
            case 7:
                PremioDAO premioDAO = new PremioDAO();
                switch (vista_menu.menuPremioCase6()) {
                    case 1:
                        musico.getPremios().add(premioDAO.obtener(vista_premio.pedirNombre()));
                    case 2:
                        musico.getPremios().remove(premioDAO.obtener(vista_premio.pedirNombre()));
//                        for (Premio premio : cantante.getPremios()) {
//                            if (premio.getNombre() == vista_premio.pedirNombre) {
//                                cantante.getPremios().remove(premio);
//                            }
//
//                        }
                }
            case 0:
                break;
        }
    }
}
