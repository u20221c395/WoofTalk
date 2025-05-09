package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Rol;

import java.util.List;

public interface IRolServices {
    public List<Rol> list();
    public void insert(Rol rol);
    public void update(Rol r);
    public Rol listarId(int id);
    public void delete(int id);
    public List<String[]> cantidadTotalDeRolUsuariosRegistrados();

}
