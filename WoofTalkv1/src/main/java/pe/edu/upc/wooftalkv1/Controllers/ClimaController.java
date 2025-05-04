package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.ClimaDTO;
import pe.edu.upc.wooftalkv1.entities.Clima;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IClimaServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/climas")
public class ClimaController {

    @Autowired
    private IClimaServices cS;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<Clima> listar() {
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,Clima.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void agregar(@RequestBody ClimaDTO climaDTO){
        ModelMapper m = new ModelMapper();
        Clima c = m.map(climaDTO,Clima.class);
        cS.insert(c);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody ClimaDTO climaDTO){
        ModelMapper m = new ModelMapper();
        Clima c = m.map(climaDTO,Clima.class);
        cS.update(c);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public ClimaDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        ClimaDTO climaDTO=m.map(cS.listarId(id),ClimaDTO.class);
        return climaDTO;
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        cS.delete(id);
    }
}

