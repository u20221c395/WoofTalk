package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.entities.Rol;
import pe.edu.upc.wooftalkv1.repositories.IMascotasRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IMascotasServices;

import java.util.List;
@Service
public class MascotasServiceImplement implements IMascotasServices {
    @Autowired
    private IMascotasRepository mR;

    @Override
    public List<Mascotas> list() {
        return mR.findAll();
    }
    @Override
    public void insert(Mascotas mascotas) {
        mR.save(mascotas);
    }

    @Override
    public void update(Mascotas mascotas) {
        mR.save(mascotas);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }
}
