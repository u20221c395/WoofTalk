package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Geolocalizacion;

import java.util.List;

public interface IGeolocalizacionServices {
    public List<Geolocalizacion> list();
    public void insert(Geolocalizacion geolocalizacion);
}

