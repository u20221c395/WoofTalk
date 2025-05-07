package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.SolicitudDTO;
import pe.edu.upc.wooftalkv1.entities.Solicitud;
import pe.edu.upc.wooftalkv1.servicesInterfaces.ISolicitudServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private ISolicitudServices iSolicitudServices;

    //Listar Solicitud
    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<SolicitudDTO> obtenerSolicitud(){

        return iSolicitudServices.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,SolicitudDTO.class);
        }).collect(Collectors.toList());
    }

    //Registrar Solicitud
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody SolicitudDTO solicitudDTO) {
        ModelMapper m = new ModelMapper();
        Solicitud solicitud = m.map(solicitudDTO, Solicitud.class);
        iSolicitudServices.registrar(solicitud);
    }

    //Listar por Id Solicitud
    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public SolicitudDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        SolicitudDTO solicitudDTO=m.map(iSolicitudServices.listarId(id),SolicitudDTO.class);
        return solicitudDTO;
    }

    //Actualizar Solicitud
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void actualizar(@RequestBody SolicitudDTO solicitudDTO){
        ModelMapper m=new ModelMapper();
        Solicitud solicitud=m.map(solicitudDTO,Solicitud.class);
        iSolicitudServices.actualizar(solicitud);
    }

    //Eliminar Solicitud
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        iSolicitudServices.eliminar(id);
    }
}

