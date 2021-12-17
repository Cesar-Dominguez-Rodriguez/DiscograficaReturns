package controllers;

import views.Vsta_Menu;

public class Ctrl_menu {

    private Vsta_Menu vsta_menu;
    private Ctrl_cantante ctrl_cantante;
    private Ctrl_musico ctrl_musico;
    private Ctrl_disco ctrl_disco;
    private Ctrl_pista ctrl_pista;
    private Ctrl_premio ctrl_premio;

    public Ctrl_menu() {
        vsta_menu= new Vsta_Menu();
        ctrl_cantante = new Ctrl_cantante();
        ctrl_musico = new Ctrl_musico();
        ctrl_disco = new Ctrl_disco();
        ctrl_pista = new Ctrl_pista();
        ctrl_premio = new Ctrl_premio();
    }

    public void ejecucion() {
        Boolean ejecucion = true;
        while (ejecucion) {
            try {
                switch (vsta_menu.menuPrincipal()) {
                    case 1:
                        ctrl_cantante.ctrl(vsta_menu.menuCantante());
                        break;
                    case 2:
                        ctrl_musico.ctrl(vsta_menu.menuMusico());
                        break;
                    case 3:
                        ctrl_disco.ctrl(vsta_menu.menuDisco());
                        break;
                    case 4:
                        ctrl_pista.ctrl(vsta_menu.menuPista());
                        break;
                    case 5:
                        ctrl_premio.ctrl(vsta_menu.menuPremio());
                        break;
                    case 0:
                        ejecucion = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage()+ e.getCause());
            }
        }
    }
}
