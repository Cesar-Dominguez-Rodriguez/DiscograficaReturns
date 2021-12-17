package models;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public interface DAO {

    Object obtener(String nombreABuscar);

    void anhadir(Object objeto);

    void actualizar(Object objeto);

    List<Object> listar();

    void eliminar(String nombre);


}
