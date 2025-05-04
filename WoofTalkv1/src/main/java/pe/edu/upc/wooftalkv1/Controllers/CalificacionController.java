package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.CalificacionDTO;
import pe.edu.upc.wooftalkv1.entities.Calificacion;
import pe.edu.upc.wooftalkv1.servicesInterfaces.ICalificacionServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    @Autowired
    private ICalificacionServices icalificacionServices;

    //Listar Calificacion
    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<CalificacionDTO> obtenerCalificaciones(){

        return icalificacionServices.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,CalificacionDTO.class);
        }).collect(Collectors.toList());
    }

    //Registrar Calificacion
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody CalificacionDTO calificacionDTO) {
        ModelMapper m = new ModelMapper();
        Calificacion calificacion = m.map(calificacionDTO, Calificacion.class);
        icalificacionServices.registrar(calificacion);
    }

    //Listar por Id Calificacion
    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public CalificacionDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        CalificacionDTO dto=m.map(icalificacionServices.find(id),CalificacionDTO.class);
        return dto;
    }

    //Actualizar Calificacion
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void actualizar(@RequestBody CalificacionDTO calificacionDTO){
        ModelMapper m=new ModelMapper();
        Calificacion calificacion =m.map(calificacionDTO,Calificacion.class);
        icalificacionServices.actualizar(calificacion);
    }

    //Eliminar Calificacion
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        icalificacionServices.eliminar(id);
    }
}


