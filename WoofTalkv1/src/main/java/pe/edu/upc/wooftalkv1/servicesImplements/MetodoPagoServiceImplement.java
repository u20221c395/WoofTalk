package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.MetodoPago;
import pe.edu.upc.wooftalkv1.repositories.IMetodoPagoRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IMetodoPagoServices;

import java.util.List;
@Service
public class MetodoPagoServiceImplement implements IMetodoPagoServices {
  @Autowired
   private IMetodoPagoRepository mpR;

    @Override
    public List<MetodoPago> list() {
        return mpR.findAll();
    }

    @Override
    public void insert(MetodoPago metodoPago) {
        mpR.save(metodoPago);
    }

    @Override
    public void update(MetodoPago metodoPago) {
        mpR.save(metodoPago);
    }

    @Override
    public MetodoPago listarId(int id) {
        return mpR.findById(id).orElse(new MetodoPago());
    }

    @Override
    public void delete(int id) {
        mpR.deleteById(id);
    }
}
