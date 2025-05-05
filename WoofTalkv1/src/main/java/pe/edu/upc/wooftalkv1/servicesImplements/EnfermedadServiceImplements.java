package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Enfermedad;
import pe.edu.upc.wooftalkv1.repositories.IEnfermedadRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IEnfermedadServices;

import java.util.List;

@Service
public class EnfermedadServiceImplements implements IEnfermedadServices {
    @Autowired
    private IEnfermedadRepository eR;


    @Override
    public List<Enfermedad> list() {
        return eR.findAll  ();
    }

    @Override
    public void insert(Enfermedad enfermedad) {
    eR.save(enfermedad);
    }

    @Override
    public void update(Enfermedad e) {
eR.save(e);
    }

    @Override
    public void delete(int id) {
eR.deleteById(id);
    }

    @Override
    public List<String[]> buscarMascotasPorEnfermedad(String name) {
        return eR.buscarMascotasPorEnfermedad(name);
    }


}
