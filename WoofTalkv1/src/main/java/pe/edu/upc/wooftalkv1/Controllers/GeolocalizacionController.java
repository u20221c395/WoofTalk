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
}
