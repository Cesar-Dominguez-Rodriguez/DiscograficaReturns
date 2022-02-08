package views;

import java.util.Scanner;

public class Vsta_Menu implements Vsta_Pedir_Por_Datos {

    public Vsta_Menu() {}

    public int menuPrincipal() {
        return pedirEntero("Discografica\n" +
                "\n Menu Principal\n" +
                "  Indica que quieres modificar:\n" +
                "   1. Cantante\n" +
                "   2. Músico\n" +
                "   3. Disco\n" +
                "   4. Pista\n" +
                "   5. Premio\n" +
                "   0. Salir\n" +
                "  Extra\n" +
                "   6. Consultas\n");
    }


    public int menuCantante(){
        return pedirEntero("Cantante\n" +
                " Indica que accion quieras realizar:\n" +
                "  1. Añadir un nuevo cantante\n" +
                "  2. Modificar un cantante\n" +
                "  3. Listar los cantantes\n" +
                "  4. Eliminar un cantante\n" +
                "  0. Volver al Menu Principal\n");
    }

    public int menuMusico(){
        return pedirEntero("Músico\n" +
                " Indica que accion quieras realizar:\n" +
                "  1. Añadir un nuevo músico\n" +
                "  2. Modificar un músico\n" +
                "  3. Listar los músicos\n" +
                "  4. Eliminar un músico\n" +
                "  0. Volver al Menu Principal\n");
    }

    public int menuDisco(){
        return pedirEntero("Disco\n" +
                " Indica que accion quieras realizar:\n" +
                "  1. Añadir un nuevo disco\n" +
                "  2. Modificar un disco\n" +
                "  3. Listar los discos\n" +
                "  4. Eliminar un disco\n" +
                "  0. Volver al Menu Principal\n");
    }

    public int menuPista(){
        return pedirEntero("Pista\n" +
                " Indica que accion quieras realizar:\n" +
                "  1. Añadir una nueva pista\n" +
                "  2. Modificar una pista\n" +
                "  3. Listar las pistas\n" +
                "  4. Eliminar una pista\n" +
                "  0. Volver al Menu Principal\n");
    }

    public int menuPremio(){
        return pedirEntero("Premio\n" +
                " Indica que accion quieras realizar:\n" +
                "  1. Añadir un nuevo premio\n" +
                "  2. Modificar un premio\n" +
                "  3. Listar los premios\n" +
                "  4. Eliminar un premio\n" +
                "  0. Volver al Menu Principal\n");
    }

    public int menuPremioCase6(){
        return pedirEntero("modificar premios de artista\n" +
                " Añadir o eliminar un premio?:\n" +
                "  1. Añadir un nuevo premio\n" +
                "  2. Eliminar un premio\n" +
                "  0. Volver\n");
    }

    public int menuConsultas(){
        return pedirEntero("Elige que consulta realizar\n" +
                "1 Numero de Canciones por artista\n" +
                "2 \n" +
                "3 \n" +
                "4 \n" +
                "5 \n");
    }
    /// Peticion de datos por tipo //////

    @Override
    public String pedirString(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        String cadena = "";
        cadena = scanner.nextLine();
        return cadena;
    }

    @Override
    public int pedirEntero(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        System.out.println(mensaje);
        valor = scanner.nextInt();
        return valor;
    }

    @Override
    public double pedirDecimalDoble(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        double valor = 0;
        valor = scanner.nextDouble();
        return valor;
    }

    @Override
    public float pedirDecimal(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        float valor = 0;
        valor = scanner.nextFloat();
        return valor;
    }

    @Override
    public Boolean Si_o_No(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        Boolean campoCorrecto = false;
        Boolean retorno = false;
        mensaje = mensaje + "S=si  N=no";
        System.out.println(mensaje);
        char campo = scanner.nextLine().charAt(0);

        while (!campoCorrecto) {
            if (campo != 'S' || campo != 's' || campo != 'N' || campo != 'n') {
                System.out.println("Introduce una opcion correcta");
            } else if (campo == 'S' || campo == 's') {
                campoCorrecto = true;
                retorno= false;
            } else if (campo == 'N' || campo == 'n') {
                campoCorrecto= true;
                retorno= false;
            }
        }
        return retorno;
    }
}
