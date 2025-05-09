package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Enfermedad;

import java.util.List;

public interface IEnfermedadServices {
    public List<Enfermedad> list();
    public void insert(Enfermedad enfermedad);
    public void update(Enfermedad e);
    public Enfermedad ListarId(int id);
    public void delete(int id);

    public List<String[]> buscarMascotasPorEnfermedad(String name);


}
