package views;

import java.util.Scanner;

public class Vsta_premio implements Vsta_Pedir_Por_Datos{

    public Vsta_premio() {}

    public int modificarAtributo(){
        return pedirEntero("Indica que atributo quieres modificar:\n" +
                "1. Nombre\n" +
                "2. Dinero\n" +
                "3. Artista\n" +
                "0. Cancelar\n");
    }

    public String pedirNombre(){
        return pedirString("Introduce el nombre del premio:");
    }

    public Float pedirDinero(){
        return pedirDecimal("Introduce el dinero del premio:");
    }

    public String pedirMaterial(){
        return pedirString("Introduce el material del premio");
    }

    public int pedirAnhoFundacion(){
        return pedirEntero("Indica el año de fundacion");
    }

    public int tipoDeArtista(){
        return pedirEntero("Introduce el tipo de artista:\n" +
                "1. Cantante\n" +
                "2. Músico");
    }

    public int modificarArtista(){
        return pedirEntero("Indica que accion quieres realizar\n" +
                " 1. Añadir artista\n" +
                " 2. Eliminar artista");

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
