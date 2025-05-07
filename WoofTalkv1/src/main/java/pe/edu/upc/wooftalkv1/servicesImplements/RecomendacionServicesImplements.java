package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Recomendacion;
import pe.edu.upc.wooftalkv1.repositories.IRecomendacionRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IRecomendacionServices;

import java.util.List;

@Service
public class RecomendacionServicesImplements implements IRecomendacionServices {

    @Autowired
    private IRecomendacionRepository recomendacionRepository;

    //Listar Recomendacion
    @Override
    public List<Recomendacion> listar() {return recomendacionRepository.findAll();}

    //Registrar Recomendacion
    @Override
    public Recomendacion registrar(Recomendacion recomendacion) {return recomendacionRepository.save(recomendacion);}

    //Listar por Id Recomendacion
    @Override
    public Recomendacion listarId(int id) {
        return recomendacionRepository.findById(id).orElse(new Recomendacion());
    }

    //Actualizar Recomendacion
    @Override
    public void actualizar(Recomendacion recomendacion) {recomendacionRepository.save(recomendacion); }

    //Eliminar Recomendacion
    @Override
    public void eliminar(int id) {
        recomendacionRepository.deleteById(id);
    }
}
