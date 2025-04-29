package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Clima;
import pe.edu.upc.wooftalkv1.repositories.IClimaRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IClimaServices;

import java.util.List;

@Service
public class ClimaServiceImplement implements IClimaServices {
    @Autowired
    private IClimaRepository cRe;

    @Override
    public List<Clima> list(){
        return cRe.findAll();
    }

    @Override
    public void insert(Clima clima) {
        cRe.save(clima);
    }

    @Override
    public void update(Clima c){
        cRe.save(c);
    }

    @Override
    public void delete(int id){
        cRe.deleteById(id);
    }
}
