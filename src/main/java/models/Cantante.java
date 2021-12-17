package models;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name= "cantantes")
//@DiscriminatorValue(value = "1")
public class Cantante extends Artista{

    private RegistroVoz voz;

    public Cantante() {
    }

    public Cantante(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical, List<Disco> discos, List<Pista> pistas, List<Premio> premios, RegistroVoz voz) {
        super(dni, nombre, nombreArtistico, salario, estiloMusical, discos, pistas, premios);
        this.voz = voz;
    }

    public Cantante(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical, List<Disco> discos, List<Pista> pistas, List<Premio> premios) {
        super(dni, nombre, nombreArtistico, salario, estiloMusical, discos, pistas, premios);
    }

    public Cantante(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical, RegistroVoz voz) {
        super(dni, nombre, nombreArtistico, salario, estiloMusical);
        this.voz = voz;
    }

    public Cantante(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical) {
        super(dni, nombre, nombreArtistico, salario, estiloMusical);
    }

    public RegistroVoz getVoz() {
        return voz;
    }

    public void setVoz(RegistroVoz voz) {
        this.voz = voz;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "idArtista=" + super.getIdArtista() +
                ", dni= '" + super.getDni() + '\'' +
                ", nombre = '" + super.getNombre() + '\'' +
                ", nombreArtistico = '" + super.getNombreArtistico() + '\'' +
                ", salario = " + super.getSalario() +
                ", estiloMusical = '" + super.getEstiloMusical() + '\'' +
                ", discos = " + super.getDiscos() +
                ", pistas = " + super.getPistas() +
                ", premios = " + super.getPremios() +
                ", voz=" + voz +
                '}';
    }
}
