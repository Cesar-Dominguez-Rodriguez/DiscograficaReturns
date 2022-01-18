package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "discos")
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "iddisco")
    private int idDisco;
    private String nombre;
    private String anhoSalida;
    private int numeroCanciones;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "disco", cascade= CascadeType.ALL)
    private List<Pista> pistas;


    @ManyToOne
    @JoinColumn(name = "FK_ARTISTA")
    private Artista artista;

    public Disco() {
    }

    public Disco(String nombre, String anhoSalida, int numeroCanciones, Artista artista) {
        this.nombre = nombre;
        this.anhoSalida = anhoSalida;
        this.numeroCanciones = numeroCanciones;
        this.pistas = new ArrayList<>();
        this.artista = artista;
    }

    public void anhadirPista(Pista p){
        pistas.add(p);
    }

    public void eliminarPista(Pista p){
        pistas.remove(p);
        p.setDisco(null);
    }

    public int getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(int idDisco) {
        this.idDisco = idDisco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pista> getPistas() {
        return pistas;
    }

    public void setPistas(List<Pista> pistas) {
        this.pistas = pistas;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Disco \n" +
                " nombre: " + nombre +'\n' +
                "  anhoSalida: " + anhoSalida +'\n'+
                "  numeroCanciones: " + numeroCanciones +'\n'+
                "  pistas: " + pistas +
                "  artista: " + artista.getNombreArtistico();
    }
}
