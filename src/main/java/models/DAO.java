package models;

import java.util.List;

public interface DAO {

    Object obtener(String nombreABuscar);

    void anhadir(Object objeto);

    void actualizar(Object objeto);

    void actualizarCantante(Object objeto);

    List<Cantante> listarCantante();

    List<Disco> listarDisco();

    List<Pista> listarPista();

    List<Premio> listarPremio();

    List<Musico> listarMusico();

    void eliminar(String nombre);


}
