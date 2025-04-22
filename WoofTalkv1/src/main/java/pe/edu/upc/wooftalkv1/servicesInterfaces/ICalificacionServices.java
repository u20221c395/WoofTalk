package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Calificacion;

import java.util.List;

public interface ICalificacionServices {

    //Listar Calificacion
    public List<Calificacion> listar();

    //Registrar Calificacion
    public Calificacion registrar (Calificacion calificacion);

    //Listar por Id Calificacion
    public List<Calificacion> find(int id);

    //Actualizar Calificacion
    public void actualizar(Calificacion calificacion);

    //Eliminar Calificacion
    void eliminar(int id);
}
