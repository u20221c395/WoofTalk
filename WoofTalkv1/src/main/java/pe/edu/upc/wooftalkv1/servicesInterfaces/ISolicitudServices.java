package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Solicitud;

import java.util.List;

public interface ISolicitudServices {

    //Listar Solicitud
    public List<Solicitud> listar();

    //Registrar Solicitud
    public Solicitud registrar(Solicitud solicitud);

    //Listar por Id Solicitud
    public Solicitud listarId(int id);

    //Actualizar Solicitud
    public void actualizar(Solicitud solicitud);

    //Eliminar Solicitud
    void eliminar(int id);
}
