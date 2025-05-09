package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.*;
import pe.edu.upc.wooftalkv1.entities.Enfermedad;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IEnfermedadServices;

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

    @PostMapping("/agregar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void insertar(@RequestBody EnfermedadDTO enfermedadDTO) {

        ModelMapper m = new ModelMapper();
        Enfermedad r = m.map(enfermedadDTO, Enfermedad.class);
        rE.insert(r);
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody EnfermedadDTO dto) {
        ModelMapper m = new ModelMapper();
        Enfermedad r = m.map(dto , Enfermedad.class);
        rE.update(r);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
        public EnfermedadDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        EnfermedadDTO dto=m.map(rE.ListarId(id),EnfermedadDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id) {
        rE.delete(id);
    }

    @GetMapping("/mascotasPorEnfermedad/{nombreEnfermedad}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<BuscarPorMascotaDTO> listarMascotasPorEnfermedad(@RequestParam String nombreEnfermedad) {
        List<String[]> resultados = rE.buscarMascotasPorEnfermedad(nombreEnfermedad);

        return resultados.stream().map(resultado -> {
            BuscarPorMascotaDTO dto = new BuscarPorMascotaDTO();
            if (resultado.length >= 2) {
                dto.setNombreEnfermedad(resultado[0]);
                dto.setNombreMascota(resultado[1]);
            }
            return dto;
        }).collect(Collectors.toList());
    }

    }



