package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Paseo;

import java.time.LocalDate;
import java.util.List;

public interface IPaseoServices {
    public List<Paseo> list();
    public void insert(Paseo paseo);
    public void update(Paseo paseo);
    public Paseo listarId(int id);
    public void delete(int id);

    public List<Paseo> buscarFecha_inicio(LocalDate fecha);
}
