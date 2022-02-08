package controllers;

import models.Consultas;

public class Ctrl_consultas {

    public void ctrl(int opcion) {
        Consultas consultas = new Consultas();
        switch (opcion) {
            case 1:
                consultas.cantidadDeCanciones();
                break;
            case 2:
                consultas.discosOrdenadosPorFecha();
                break;
            case 3:
                consultas.artistasQueMasDineroGanaronConPremios();
                break;
            case 4:

                break;
            case 5:

                break;
        }
    }
}
