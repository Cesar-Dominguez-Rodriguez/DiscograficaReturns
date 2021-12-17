package controllers;

import models.Premio;
import models.PremioDAO;
import views.Vsta_premio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Ctrl_premio {

    private Vsta_premio vista;

    public Ctrl_premio() {
        vista = new Vsta_premio();
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
                "",
                0,
                null
        );
        System.out.println(p.toString());
        PremioDAO premioDAO = new PremioDAO();
        premioDAO.anhadir(p);
    }

    public void modificarPremio() {
        PremioDAO premioDAO = new PremioDAO();
        Premio p = (Premio) premioDAO.obtener(vista.pedirNombre());
        modificarAtributoPremio(p);
        premioDAO.actualizar(p);
    }

    public void listarPremio() {
        PremioDAO premioDAO = new PremioDAO();
        List<Premio> listapremio = new ArrayList<>();
        List<Object> listaobjeto = premioDAO.listar();
        for (Object o : listaobjeto){
            Premio p = (Premio) o;
            listapremio.add(p);
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
            case 0:
                break;
        }
    }

}