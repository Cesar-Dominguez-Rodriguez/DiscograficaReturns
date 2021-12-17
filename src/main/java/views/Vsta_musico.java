package views;

import java.util.Scanner;

public class Vsta_musico implements Vsta_Pedir_Por_Datos{

    public Vsta_musico() {}


    public int modificarAtributo(){
        return pedirEntero("Indica que atributo quieres modificar:\n" +
                "1. DNI\n" +
                "2. Nombre\n" +
                "3. Nombre Artistico\n" +
                "4. salario\n" +
                "5. instrumento\n" +
                "6. Premios\n");

    }

    public String pedirDNI(){
        return pedirString("Introduce el DNI del artista");
    }

    public String pedirNombre(){
        return pedirString("Introduce el nombre del artista");
    }

    public String pedirNombreArtistico(){
        return pedirString("Introduce nombre artistico del artista");

    }

    public Float pedirSalario(){
        return pedirDecimal("Introduce el salario del artista");
    }

    public String pedirEstilo(){
        return pedirString("Introduce el estilo del artista");
    }

    public String pedirInstrumento(){
        return pedirString("Introduce el instrumento del artista");

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
