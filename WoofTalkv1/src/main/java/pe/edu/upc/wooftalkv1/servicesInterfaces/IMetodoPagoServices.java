package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.MetodoPago;

import java.util.List;

public interface IMetodoPagoServices {
    public List<MetodoPago> list();
    public void insert(MetodoPago metodoPago);
    public void update(MetodoPago metodoPago);
    public MetodoPago listarId(int id);
    public void delete(int id);
}

