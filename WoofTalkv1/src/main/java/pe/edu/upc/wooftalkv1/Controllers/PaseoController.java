package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.PaseoDTO;
import pe.edu.upc.wooftalkv1.entities.Paseo;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IPaseoServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paseos")
public class PaseoController {
    @Autowired
    private IPaseoServices pS;

    @GetMapping("/listar")
    public List<PaseoDTO> listar() {
        return pS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, PaseoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/agregar")
    public void agregar(@RequestBody PaseoDTO paseoDTO){
        ModelMapper m = new ModelMapper();
        Paseo p = m.map(paseoDTO,Paseo.class);
        pS.insert(p);
    }

    @PutMapping
    public void modificar(@RequestBody PaseoDTO paseoDTO){
        ModelMapper m = new ModelMapper();
        Paseo p = m.map(paseoDTO,Paseo.class);
        pS.update(p);
    }

    @DeleteMapping("{id}")
    public void eliminar(@PathVariable("id") int id){
        pS.delete(id);
    }
}
