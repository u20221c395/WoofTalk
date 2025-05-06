package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.PaseoDTO;
import pe.edu.upc.wooftalkv1.entities.Paseo;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IPaseoServices;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paseos")
public class PaseoController {
    @Autowired
    private IPaseoServices pS;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<PaseoDTO> listar() {
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PaseoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void agregar(@RequestBody PaseoDTO paseoDTO){
        ModelMapper m = new ModelMapper();
        Paseo p = m.map(paseoDTO,Paseo.class);
        pS.insert(p);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody PaseoDTO paseoDTO){
        ModelMapper m = new ModelMapper();
        Paseo p = m.map(paseoDTO,Paseo.class);
        pS.update(p);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public PaseoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PaseoDTO paseoDTO = m.map(pS.listarId(id), PaseoDTO.class);
        return paseoDTO;
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        pS.delete(id);
    }

    @GetMapping("/buscarporfecha")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<PaseoDTO> buscarFechaInicio(@RequestParam LocalDate fecha) {
        return pS.buscarFecha_inicio(fecha).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y, PaseoDTO.class);
        }).collect(Collectors.toList());
    }

}

