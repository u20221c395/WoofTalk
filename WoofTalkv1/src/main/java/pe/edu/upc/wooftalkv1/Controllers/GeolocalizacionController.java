package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.GeolocalizacionDTO;
import pe.edu.upc.wooftalkv1.entities.Geolocalizacion;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IGeolocalizacionServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/geolocalizaciones")
public class GeolocalizacionController {
    @Autowired
    private IGeolocalizacionServices gS;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    private List<GeolocalizacionDTO> lista() {
        return gS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, GeolocalizacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    private void insert(@RequestBody GeolocalizacionDTO geolocalizacionDTO) {
        ModelMapper m = new ModelMapper();
        Geolocalizacion geolocalizacion = m.map(geolocalizacionDTO, Geolocalizacion.class);
        gS.insert(geolocalizacion);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody GeolocalizacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Geolocalizacion g = m.map(dto , Geolocalizacion.class);
        gS.update(g);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public GeolocalizacionDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        GeolocalizacionDTO dto=m.map(gS.ListarId(id),GeolocalizacionDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id) {
        gS.delete(id);
    }
}
