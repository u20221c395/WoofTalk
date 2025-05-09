package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Contrato;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.entities.MetodoPago;

import java.util.List;

public interface IContratoServices {
    public List<Contrato> list();
    public void insert(Contrato contrato);
    public Contrato find(int id);
    public void update(Contrato c);
    public void delete(int id);

    List<Contrato> buscarContratoMascotas(Mascotas mascotas);
    List<Contrato> buscarContratosPorMonto(double monto);
}
