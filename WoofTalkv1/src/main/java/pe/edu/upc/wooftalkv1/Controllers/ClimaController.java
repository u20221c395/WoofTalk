package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Clima> listar() {
        return cS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,Clima.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/agregar")
    public void agregar(@RequestBody ClimaDTO climaDTO){
        ModelMapper m = new ModelMapper();
        Clima c = m.map(climaDTO,Clima.class);
        cS.insert(c);
    }

    @PutMapping
    public void modificar(@RequestBody ClimaDTO climaDTO){
        ModelMapper m = new ModelMapper();
        Clima c = m.map(climaDTO,Clima.class);
        cS.update(c);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") int id){
        cS.delete(id);
    }
}
