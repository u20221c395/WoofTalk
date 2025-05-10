package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Contrato;
import pe.edu.upc.wooftalkv1.repositories.IContratoRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IContratoServices;

import java.time.LocalDate;
import java.util.List;


@Service
public class ContratoServiceImplement implements IContratoServices {
    @Autowired
    private IContratoRepository coR;

    @Override
    public List<Contrato> list() {
        return coR.findAll();
    }

    @Override
    public void insert(Contrato contrato) { coR.save(contrato);}

    @Override
    public void update(Contrato c) {coR.save(c);}

    @Override
    public Contrato find(int id) {return coR.findById(id).orElse(new Contrato());}

    @Override
    public void delete(int id) {coR.deleteById(id);}

    @Override
    public List<Contrato> buscarContratoPorFecha(LocalDate fecha_inicio) {
        return coR.buscarContratosFechaInicio(fecha_inicio);
    }

    @Override
    public List<Contrato> buscarContratoPorMonto(double monto) {
        return coR.buscarContratosPorMonto(monto);
    }

}
