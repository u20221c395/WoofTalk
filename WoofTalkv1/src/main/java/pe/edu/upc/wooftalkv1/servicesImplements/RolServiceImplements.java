package pe.edu.upc.wooftalkv1.servicesImplements;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Rol;
import pe.edu.upc.wooftalkv1.repositories.IRolRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IRolServices;

import java.util.List;

@Service
public class RolServiceImplements implements IRolServices {

    private static final Logger log = LoggerFactory.getLogger(RolServiceImplements.class);
    @Autowired
    private IRolRepository rS;
    @Override
    public List<Rol> list() {
        return rS.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rS.save(rol);
    }

    @Override
    public void update(Rol r) {
        rS.save(r);
    }

    @Override
    public Rol listarId(int id) {
        return rS.findById(id).orElse(new Rol());
    }

    @Override
    public void delete(int id) {
        rS.deleteById(id);
    }

    @Override
    public List<String[]> cantidadTotalDeRolUsuariosRegistrados() {
        return rS.cantidadTotalDeRolUsuariosRegistrados();
    }
}
