package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Recomendacion;

import java.util.List;

public interface IRecomendacionServices {

    //Listar Recomendacion
    public List<Recomendacion> listar();

    //Registrar Recomendacion
    public Recomendacion registrar(Recomendacion recomendacion);

    //Listar por Id Recomendacion
    public Recomendacion listarId(int id);

    //Actualizar Recomendacion
    public void actualizar(Recomendacion recomendacion);

    //Eliminar Recomendacion
    void eliminar(int id);


}
