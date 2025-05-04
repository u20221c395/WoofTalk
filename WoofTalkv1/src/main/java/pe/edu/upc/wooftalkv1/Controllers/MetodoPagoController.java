package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.ClimaDTO;
import pe.edu.upc.wooftalkv1.DTOS.MetodoPagoDTO;
import pe.edu.upc.wooftalkv1.DTOS.UsuarioDTO;
import pe.edu.upc.wooftalkv1.entities.Clima;

import pe.edu.upc.wooftalkv1.entities.MetodoPago;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IMetodoPagoServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metodos de pago")
public class MetodoPagoController {

    @Autowired
    private IMetodoPagoServices mpS;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<MetodoPagoDTO> listar() {
        return mpS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, MetodoPagoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void agregar(@RequestBody MetodoPagoDTO metodoPagoDTO){
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(metodoPagoDTO,MetodoPago.class);
        mpS.insert(mp);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody MetodoPagoDTO metodoPagoDTO){
        ModelMapper m = new ModelMapper();
        MetodoPago mp = m.map(metodoPagoDTO,MetodoPago.class);
        mpS.update(mp);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public MetodoPagoDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MetodoPagoDTO metodoPagoDTO = m.map(mpS.listarId(id), MetodoPagoDTO.class);
        return metodoPagoDTO;
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        mpS.delete(id);
    }
}
