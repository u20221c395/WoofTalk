package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.BuscarContratoDTO;
import pe.edu.upc.wooftalkv1.DTOS.ContratoDTO;
import pe.edu.upc.wooftalkv1.DTOS.ContratoMontoDTO;
import pe.edu.upc.wooftalkv1.entities.Contrato;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.entities.MetodoPago;
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

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody ContratoDTO dto) {
        ModelMapper m = new ModelMapper();
        Contrato r = m.map(dto , Contrato.class);
        coS.update(r);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public ContratoDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        ContratoDTO dto=m.map(coS.find(id),ContratoDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id) {
        coS.delete(id);
    }


    @GetMapping("/buscarcontratoporfecha")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<BuscarContratoDTO> buscarContratoMascotas(@RequestParam LocalDate fecha_inicio) {
        return coS.buscarContratoPorFecha(fecha_inicio).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y, BuscarContratoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/buscarcontratopormonto")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ContratoMontoDTO> buscarContratoPorMonto(@RequestParam double monto) {
        return coS.buscarContratoPorMonto(monto).stream().map(y ->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ContratoMontoDTO.class);
        }).collect(Collectors.toList());
    }

}

