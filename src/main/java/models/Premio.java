package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "premios")
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idpremio")
    private int idPremio;
    private String nombre;
    private float dinero;
    private String material;
    private int anhoFundacion;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="pre_art",joinColumns = @JoinColumn(name="idpremio"),inverseJoinColumns = @JoinColumn(name= "idartista"))
    private List<Artista> artistas;

    public Premio(){
    }

    public Premio(String nombre, float dinero, String material, int anhoFundacion) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.material = material;
        this.anhoFundacion = anhoFundacion;
        this.artistas = new ArrayList<>();
    }

    public int getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(int idPremio) {
        this.idPremio = idPremio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getAnhoFundacion() {
        return anhoFundacion;
    }

    public void setAnhoFundacion(int anhoFundacion) {
        this.anhoFundacion = anhoFundacion;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }


    @Override
    public String toString() {
        return "Premio{" +
                "idPremio=" + idPremio +
                ", nombre='" + nombre + '\'' +
                ", dinero=" + dinero +
                '}';
    }
}
