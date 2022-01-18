package models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
//@DiscriminatorValue(value = "2")
public class Musico extends Artista{


    private String instrumento;

    public Musico() {
    }

    public Musico(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical, String instrumento) {
        super(dni, nombre, nombreArtistico, salario, estiloMusical);
        this.instrumento = instrumento;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "idArtista=" + super.getIdArtista() +
                " DNI= '" + super.getDni() + '\'' +
                " Nombre = '" + super.getNombre() + '\'' +
                " NombreArtistico = '" + super.getNombreArtistico() + '\'' +
                " Salario = " + super.getSalario() +
                " EstiloMusical = '" + super.getEstiloMusical() + '\'' +
                " Discos = " + super.getDiscos() +
                " Pistas = " + super.getPistas() +
                " Premios = " + super.getPremios() +
                " Instrumento=" + instrumento +
                '}';
    }
}
