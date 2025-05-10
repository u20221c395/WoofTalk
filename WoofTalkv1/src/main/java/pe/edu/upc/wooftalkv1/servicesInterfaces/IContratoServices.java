package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Contrato;


import java.time.LocalDate;
import java.util.List;

public interface IContratoServices {
    public List<Contrato> list();
    public void insert(Contrato contrato);
    public Contrato find(int id);
    public void update(Contrato c);
    public void delete(int id);

    List<Contrato> buscarContratoPorFecha(LocalDate fecha_inicio);
    List<Contrato> buscarContratoPorMonto(double monto);
}
