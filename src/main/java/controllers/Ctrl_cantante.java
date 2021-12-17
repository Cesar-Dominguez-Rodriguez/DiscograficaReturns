package controllers;

import models.*;
import views.Vsta_Menu;
import views.Vsta_cantante;
import views.Vsta_disco;
import views.Vsta_premio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_cantante {

    private Vsta_cantante vista;
    private Vsta_premio vista_premio;
    private Vsta_Menu vista_menu;
    private Ctrl_premio ctrl_premio;


    public Ctrl_cantante() {
        vista = new Vsta_cantante();
        vista_menu = new Vsta_Menu();
        ctrl_premio = new Ctrl_premio();
        vista_premio = new Vsta_premio();
    }

    public void ctrl(int option) {
        Boolean ejecucion = true;
        while (ejecucion) {
            switch (option) {
                case 1:
                    anhadirCantante();
                    ejecucion = false;
                    break;
                case 2:
                    modificarCantante();
                    ejecucion = false;
                    break;
                case 3:
                    listarCantante();
                    ejecucion = false;
                    break;
                case 4:
                    eliminarCantante();
                    ejecucion = false;
                    break;
                case 0:
                    ejecucion = false;
                    break;
            }
        }
    }

    public void anhadirCantante() {
        List<Disco> discos = new ArrayList<>();
        List<Pista> pistas = new ArrayList<>();
        List<Premio> premios = new ArrayList<>();
        Cantante c = new Cantante(
                vista.pedirDNI(),
                vista.pedirNombre(),
                vista.pedirNombreArtistico(),
                vista.pedirSalario(),
                vista.pedirEstilo(),
                discos,
                pistas,
                premios,
                seleccionDeVoz()
        );
        CantanteDAO cantanteDAO = new CantanteDAO();
        cantanteDAO.anhadir(c);
    }

    public void modificarCantante() {
        CantanteDAO cantanteDAO = new CantanteDAO();
        Cantante c = (Cantante) cantanteDAO.obtener(vista.pedirNombreArtistico());
        modificarAtributoCantante(c);
        cantanteDAO.actualizar(c);
    }

    public void listarCantante() {
        CantanteDAO cantanteDAO = new CantanteDAO();
        List<Cantante> listacantante = new ArrayList<>();
        List<Object> listaobjeto = cantanteDAO.listar();
        for (Object o : listaobjeto) {
            Cantante c = (Cantante) o;
            listacantante.add(c);
            System.out.println(c.toString());
        }

    }

    public void eliminarCantante() {
        CantanteDAO cantanteDAO = new CantanteDAO();
        cantanteDAO.eliminar(vista.pedirNombre());
    }

    public RegistroVoz seleccionDeVoz() {
        RegistroVoz registroVoz = null;

        switch (vista.seleccionVoz()) {
            case 1:
                registroVoz = RegistroVoz.Tenor;
                break;
            case 2:
                registroVoz = RegistroVoz.Contratenor;
                break;
            case 3:
                registroVoz = RegistroVoz.Baritono;
                break;
            case 4:
                registroVoz = RegistroVoz.Bajo;
                break;
            case 5:
                registroVoz = RegistroVoz.Soprano;
                break;
            case 6:
                registroVoz = RegistroVoz.Mezzosoprano;
                break;
            case 7:
                registroVoz = RegistroVoz.Contraalto;
                break;
            case 8:
                registroVoz = RegistroVoz.Grutal;
                break;
            case 0:
                break;
        }
        return registroVoz;
    }

    private void modificarAtributoCantante(Cantante cantante) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        switch (vista.modificarAtributo()) {
            case 1:
                cantante.setDni(vista.pedirDNI());
                break;
            case 2:
                cantante.setNombre(vista.pedirNombre());
                break;
            case 3:
                cantante.setNombreArtistico(vista.pedirNombreArtistico());
                break;
            case 4:
                cantante.setSalario(vista.pedirSalario());
                break;
            case 5:
                cantante.setVoz(seleccionDeVoz());
                break;
            case 6:
                PremioDAO premioDAO = new PremioDAO();
                switch (vista_menu.menuPremioCase6()) {
                    case 1:
                        List<Premio> premios = cantante.getPremios();
                        Premio p = (Premio) premioDAO.obtener(vista_premio.pedirNombre());
                        premios.add(p);
                        break;
                    case 2:
                        cantante.getPremios().remove(premioDAO.obtener(vista_premio.pedirNombre()));
                        break;
                }
            case 0:
                break;
        }
    }
}
