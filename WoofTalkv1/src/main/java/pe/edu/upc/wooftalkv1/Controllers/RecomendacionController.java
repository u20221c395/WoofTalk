package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.RecomendacionDTO;
import pe.edu.upc.wooftalkv1.entities.Recomendacion;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IRecomendacionServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    @Autowired
    private IRecomendacionServices recomendacionServices;

    //Listar Recomendacion
    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<RecomendacionDTO> obtenerRecomendacion(){

        return recomendacionServices.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    //Registrar Recomendacion
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody RecomendacionDTO recomendacionDTO) {
        ModelMapper m = new ModelMapper();
        Recomendacion recomendacion = m.map(recomendacionDTO, Recomendacion.class);
        recomendacionServices.registrar(recomendacion);
    }

    //Listar por Id Recomendacion
    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public RecomendacionDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        RecomendacionDTO recomendacionDTO=m.map(recomendacionServices.listarId(id),RecomendacionDTO.class);
        return recomendacionDTO;
    }

    //Actualizar Recomendacion
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void actualizar(@RequestBody RecomendacionDTO recomendacionDTO){
        ModelMapper m=new ModelMapper();
        Recomendacion recomendacion=m.map(recomendacionDTO,Recomendacion.class);
        recomendacionServices.actualizar(recomendacion);
    }

    //Eliminar Recomendacion
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        recomendacionServices.eliminar(id);
    }
}
