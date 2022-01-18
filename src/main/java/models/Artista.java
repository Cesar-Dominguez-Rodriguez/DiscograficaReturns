package models;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="tipo_artista",discriminatorType=DiscriminatorType.INTEGER)
//@DiscriminatorValue(value="0")
public abstract class Artista {

    @Id
    @Column(name = "idartista")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idArtista;

    private String dni;
    private String nombre;
    @Column(name = "nombreartistico")
    private String nombreArtistico;
    private float salario;
    @Column(name = "estilomusical")
    private String estiloMusical;

    @OneToMany(mappedBy = "artista", cascade = {CascadeType.ALL})
    private List<Disco> discos;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="pist_art",joinColumns = @JoinColumn(name="idartista"),inverseJoinColumns = @JoinColumn(name= "idpista"))
    private List<Pista> pistas;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="pre_art",joinColumns = @JoinColumn(name="idartista"),inverseJoinColumns = @JoinColumn(name= "idpremio"))
    private List<Premio> premios;

    public Artista(String dni, String nombre, String nombreArtistico, float salario, String estiloMusical) {
        this.dni = dni;
        this.nombre = nombre;
        this.nombreArtistico = nombreArtistico;
        this.salario = salario;
        this.estiloMusical = estiloMusical;
        this.discos = new ArrayList<Disco>();
        this.pistas = new ArrayList<Pista>();
        this.premios = new ArrayList<Premio>();
    }

    public Artista() {
    }

    public int getIdArtista() {
        return idArtista;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }

    public List<Pista> getPistas() {
        return pistas;
    }

    public void setPistas(List<Pista> pistas) {
        this.pistas = pistas;
    }

    public List<Premio> getPremios() {
        return premios;
    }

    public void setPremios(List<Premio> premios) {
        this.premios = premios;
    }


    public void anhadirDisco(Disco d) {
        discos.add(d);
//        d.setArtista(this);
    }

    public void eliminarDisco(Disco d) {
        this.discos.remove(d);
        d.setArtista(null);
    }
}
