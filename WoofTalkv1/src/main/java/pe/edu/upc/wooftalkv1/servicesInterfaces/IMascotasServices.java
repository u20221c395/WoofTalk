package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Clima;
import pe.edu.upc.wooftalkv1.entities.Mascotas;

import java.util.List;

public interface IMascotasServices {
    public List<Mascotas> list();
    public void insert(Mascotas mascotas);
    public void update(Mascotas mascotas);
    public void delete(int id);

}
