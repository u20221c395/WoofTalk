package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.ContratoDTO;
import pe.edu.upc.wooftalkv1.entities.Contrato;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IContratoServices;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    @Autowired
    private IContratoServices coS;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ContratoDTO> listar() {
        return coS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ContratoDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping("/agregar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void insertar(@RequestBody ContratoDTO contrato) {

        ModelMapper m = new ModelMapper();
        Contrato r = m.map(contrato, Contrato.class);
        coS.insert(r);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato r = m.map(dto , Contrato.class);
        coS.update(r);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id) {
        coS.delete(id);
    }


    @GetMapping("/buscarcontratoporidmascotas")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ContratoDTO> buscarContratoMascotas(@RequestParam Mascotas mascotas) {
        return coS.buscarContratoMascotas(mascotas).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y,ContratoDTO.class);
        }).collect(Collectors.toList());
    }

}

