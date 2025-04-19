package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.EnfermedadDTO;
import pe.edu.upc.wooftalkv1.DTOS.RolDTO;
import pe.edu.upc.wooftalkv1.entities.Enfermedad;
import pe.edu.upc.wooftalkv1.entities.Rol;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IEnfermedadServices;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IRolServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/enfermedades")
public class EnfermedadController {

    @Autowired
    private IEnfermedadServices rE;

    @GetMapping("/listar")
    public List<EnfermedadDTO> listar() {
        return rE.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, EnfermedadDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping("/agregar")
    public void insertar(@RequestBody EnfermedadDTO enfermedadDTO) {

        ModelMapper m = new ModelMapper();
        Enfermedad r = m.map(enfermedadDTO, Enfermedad.class);
        rE.insert(r);
    }

    @PutMapping
    public void modificar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad r = m.map(dto , Enfermedad.class);
        rE.update(r);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rE.delete(id);
    }

}
