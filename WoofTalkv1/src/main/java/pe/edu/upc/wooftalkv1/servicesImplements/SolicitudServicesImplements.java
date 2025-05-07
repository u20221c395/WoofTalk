package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Solicitud;
import pe.edu.upc.wooftalkv1.repositories.ISolicitudRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.ISolicitudServices;

import java.util.List;

@Service
public class SolicitudServicesImplements implements ISolicitudServices {

    @Autowired
    private ISolicitudRepository iSolicitudRepository;

    //Listar Solicitud
    @Override
    public List<Solicitud> listar() {return iSolicitudRepository.findAll();}

    //Registrar Solicitud
    @Override
    public Solicitud registrar(Solicitud solicitud) {return iSolicitudRepository.save(solicitud);}

    //Listar por Id Solicitud
    @Override
    public Solicitud listarId(int id) {
        return iSolicitudRepository.findById(id).orElse(new Solicitud());
    }

    //Actualizar Solicitud
    @Override
    public void actualizar(Solicitud solicitud) {iSolicitudRepository.save(solicitud); }

    //Eliminar Solicitud
    @Override
    public void eliminar(int id) {
        iSolicitudRepository.deleteById(id);
    }
}
