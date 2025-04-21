package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Clima;

import java.util.List;

public interface IClimaServices {
    public List<Clima> list();
    public void insert(Clima clima);
    public void update(Clima c);
    public void delete(int id);
}
