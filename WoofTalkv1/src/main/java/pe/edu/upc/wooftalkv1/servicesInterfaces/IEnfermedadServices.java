package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Enfermedad;
import pe.edu.upc.wooftalkv1.entities.Rol;

import java.util.List;

public interface IEnfermedadServices {
    public List<Enfermedad> list();
    public void insert(Enfermedad enfermedad);
    public void update(Enfermedad e);
    public void delete(int id);
}
