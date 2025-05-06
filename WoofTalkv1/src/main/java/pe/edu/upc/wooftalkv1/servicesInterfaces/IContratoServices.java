package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Contrato;
import pe.edu.upc.wooftalkv1.entities.Mascotas;

import java.util.List;

public interface IContratoServices {
    public List<Contrato> list();
    public void insert(Contrato contrato);
    public void update(Contrato c);
    public void delete(int id);

    List<Contrato> buscarContratoMascotas(Mascotas mascotas);

}
