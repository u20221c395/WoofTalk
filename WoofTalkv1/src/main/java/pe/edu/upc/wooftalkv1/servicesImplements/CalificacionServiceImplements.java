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
    private ICalificacionRepository cR;

    @Override
    public List<Calificacion> listar(){
        return cR.findAll();
    }

    @Override
    public Calificacion registrar (Calificacion calificacion) {
        return cR.save(calificacion);
    }

    @Override
    public Calificacion listarId(int id){
        return cR.findBy(id).orElse(new Calificacion());
    }

    @Override
    public void actualizar(Calificacion calificacion){
        cR.save(calificacion);
    }

    @Override
    public void eliminar(int id) {
        cR.deleteById(id);
    }
}
