package models;

import javax.persistence.*;
import java.util.List;

@Entity
//@DiscriminatorValue(value = "1")
public class Cantante extends Artista{

    private RegistroVoz voz;

    public Cantante() {
    }

    public Cantante(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical, RegistroVoz voz) {
        super(dni, nombre, nombreArtistico, salario, estiloMusical);
        this.voz = voz;
    }

    public RegistroVoz getVoz() {
        return voz;
    }

    public void setVoz(RegistroVoz voz) {
        this.voz = voz;
    }

    @Override
    public String toString() {
        return "Cantante\n " +
                " DNI= '" + super.getDni() + '\n' +
                "  Nombre: " + super.getNombre() + '\n' +
                "  Nombre artistico: '" + super.getNombreArtistico() + '\n' +
                "  Salario: " + super.getSalario() + "\n" +
                ", Estilo musical: " + super.getEstiloMusical() + '\n' +
                ", Discos:" + super.getDiscos() +
                ", pistas:  " + super.getPistas() +
                ", premios: " + super.getPremios() +
                ", voz=" + voz + "\n\n";
    }
}
