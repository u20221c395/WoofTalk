package pe.edu.upc.wooftalkv1.servicesImplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Paseo;
import pe.edu.upc.wooftalkv1.repositories.IPaseoRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IPaseoServices;

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

    }

    @Override
    public void delete(int id) {

    }
}
