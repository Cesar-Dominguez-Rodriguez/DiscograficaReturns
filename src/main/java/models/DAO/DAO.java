package models.DAO;

import java.util.List;

public interface DAO<Tipo>{

    void anhadir(Tipo t);

    Tipo obtener(String nombreABuscar);

    List<Tipo> listar();

    void actualizar(Tipo t);

    void eliminar(Tipo t);

    void eliminar(String nombre);


}
