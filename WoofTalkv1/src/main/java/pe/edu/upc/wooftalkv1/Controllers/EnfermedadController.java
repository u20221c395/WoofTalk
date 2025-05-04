package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.EnfermedadDTO;
import pe.edu.upc.wooftalkv1.DTOS.MascotasDTO;
import pe.edu.upc.wooftalkv1.DTOS.RolDTO;
import pe.edu.upc.wooftalkv1.DTOS.UsuarioDTO;
import pe.edu.upc.wooftalkv1.entities.Enfermedad;
import pe.edu.upc.wooftalkv1.entities.Rol;
import pe.edu.upc.wooftalkv1.entities.Usuario;
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
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<EnfermedadDTO> listar() {
        return rE.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, EnfermedadDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void Registrar (@RequestBody EnfermedadDTO enfermedadDTO) {
        ModelMapper m = new ModelMapper();
        Enfermedad r = m.map(enfermedadDTO, Enfermedad.class);
        rE.insert(r);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad r = m.map(dto , Enfermedad.class);
        rE.update(r);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public EnfermedadDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        EnfermedadDTO dto = m.map(rE.listarId(id), EnfermedadDTO.class);
        return dto;
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id) {
        rE.delete(id);
    }

}

