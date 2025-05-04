package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Clima;
import pe.edu.upc.wooftalkv1.entities.Paseo;
import pe.edu.upc.wooftalkv1.repositories.IClimaRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IClimaServices;

import java.util.List;

@Service
public class ClimaServiceImplement implements IClimaServices {
    @Autowired
    private IClimaRepository cR;

    @Override
    public List<Clima> list(){
        return cR.findAll();
    }

    @Override
    public void insert(Clima clima) {
        cR.save(clima);
    }

    @Override
    public void update(Clima c){
        cR.save(c);
    }

    @Override
    public Clima listarId(int id) {
        return cR.findById(id).orElse(new Clima());
    }

    @Override
    public void delete(int id){
        cR.deleteById(id);
    }
}
