package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Calificacion;
import pe.edu.upc.wooftalkv1.repositories.ICalificacionRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.ICalificacionServices;

import java.util.List;

@Service
public class CalificacionServiceImplements implements ICalificacionServices {

    @Autowired
    private ICalificacionRepository icalificacionRepository;

    //Listar Calificacion
    @Override
    public List<Calificacion> listar() {return icalificacionRepository.findAll();}

    //Registrar Calificacion
    @Override
    public Calificacion registrar(Calificacion calificacion) {return icalificacionRepository.save(calificacion);}

    //Listar por Id Calificacion
    @Override
    public Calificacion listarId(Long id) {
        return icalificacionRepository.findById(id).orElse(new Calificacion());
    }

    //Actualizar Calificacion
    @Override
    public void actualizar(Calificacion calificacion) {icalificacionRepository.save(calificacion); }

    //Eliminar Calificacion
    @Override
    public void eliminar(Long id) {
        icalificacionRepository.deleteById(id);
    }

}
