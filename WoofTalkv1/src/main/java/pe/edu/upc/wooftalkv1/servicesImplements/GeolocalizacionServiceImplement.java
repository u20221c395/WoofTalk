package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Geolocalizacion;
import pe.edu.upc.wooftalkv1.repositories.IGeolocalizacionRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IGeolocalizacionServices;

import java.util.List;

@Service
public  class GeolocalizacionServiceImplement implements IGeolocalizacionServices {
    @Autowired
    private IGeolocalizacionRepository gR;

    @Override
    public List<Geolocalizacion> list() {
        return gR.findAll();
    }

    @Override
    public void insert(Geolocalizacion geolocalizacion) {
        gR.save(geolocalizacion);
    }

    @Override
    public void update(Geolocalizacion g) {
        gR.save(g);
    }

    @Override
    public Geolocalizacion ListarId(int id) {return gR.findById(id).orElse(new Geolocalizacion());}

    @Override
    public void delete(int id) {
        gR.deleteById(id);
    }
}
