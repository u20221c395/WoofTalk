package pe.edu.upc.wooftalkv1.servicesImplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Paseo;
import pe.edu.upc.wooftalkv1.repositories.IPaseoRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IPaseoServices;

import java.time.LocalDate;
import java.util.List;
@Service
public class PaseoServiceImplement implements IPaseoServices {

    @Autowired
    private IPaseoRepository pR;

    @Override
    public List<Paseo> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Paseo paseo) {
    pR.save(paseo);
    }

    @Override
    public void update(Paseo paseo) {
        pR.save(paseo);
    }

    @Override
    public Paseo listarId(int id) {
        return pR.findById(id).orElse(new Paseo());
    }

    @Override
    public void delete(int id) {pR.deleteById(id);}

    @Override
    public List<Paseo> buscarFecha_inicio(LocalDate fecha) {return pR.buscarPaseosPorFecha(fecha);}
}
