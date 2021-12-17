package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pistas")
public class Pista {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idpista")
    private int idPista;
    private String nombre;
    private String duracion;
    private String letra;

    @ManyToOne
    @JoinColumn(name = "FK_DISCO")
    private Disco disco;

    @ManyToMany(mappedBy = "pistas")
    private List<Artista> artistas;

    public Pista(String nombre, String duracion, String letra) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.letra = letra;
        this.disco = new Disco();
        this.artistas = new ArrayList<>();
    }

    public Pista() {

    }

    public int getIdPista() {
        return idPista;
    }

    public void setIdPista(int idPista) {
        this.idPista = idPista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    @Override
    public String toString() {
        return "Pista{" +
                "idPista=" + idPista +
                ", nombre='" + nombre + '\'' +
                ", duracion='" + duracion + '\'' +
                ", Letra='" + letra + '\'' +
                ", disco=" + disco +
                '}';
    }
}
