package pe.edu.upc.wooftalkv1.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.CantidadRolUsuarioDTO;
import pe.edu.upc.wooftalkv1.DTOS.RolDTO;
import pe.edu.upc.wooftalkv1.entities.Rol;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IRolServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolServices rI;

    @GetMapping("/listar")
    public List<RolDTO> listar() {
        return rI.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());

    }

    @PostMapping("/agregar")
    public void insertar(@RequestBody RolDTO rol) {

        ModelMapper m = new ModelMapper();
        Rol r = m.map(rol, Rol.class);
        rI.insert(r);
    }

    @PutMapping("/actualizar")
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol a = m.map(dto, Rol.class);
        rI.update(a);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public RolDTO listarId(@PathVariable("id") int id){
        ModelMapper m = new ModelMapper();
        RolDTO dto=m.map(rI.listarId(id),RolDTO.class);
        return dto;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rI.delete(id);
    }


    @GetMapping("/listarCantidadDeUsuariosRegistrados")
    public List<CantidadRolUsuarioDTO> listarCantidad() {

        List<String[]>cplista=rI.cantidadTotalDeRolUsuariosRegistrados();
        List<CantidadRolUsuarioDTO>cplistaDTO =new ArrayList<>();

        for (String[] colummna:cplista){
            CantidadRolUsuarioDTO rIDTO = new CantidadRolUsuarioDTO();
            rIDTO.setCantidad(Integer.parseInt(colummna[0]));
            cplistaDTO.add(rIDTO);
        }
        return cplistaDTO;

    }
}
