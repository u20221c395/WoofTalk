package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.ObtenerUsuarioDTO;
import pe.edu.upc.wooftalkv1.DTOS.UsuarioDTO;
import pe.edu.upc.wooftalkv1.entities.Usuario;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IUsuarioServices;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioServices iusuarioServices;

    //Listar Usuario
    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<ObtenerUsuarioDTO> obtenerUsuarios(){
        return iusuarioServices.listar().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ObtenerUsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    //Registrar Usuario
    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(usuarioDTO, Usuario.class);
        iusuarioServices.registrar(usuario);
    }

    //Listar por Id Usuario
    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public UsuarioDTO listarId(@PathVariable("id") Long id){
        ModelMapper m = new ModelMapper();
        UsuarioDTO userDTO=m.map(iusuarioServices.listarId(id),UsuarioDTO.class);
        return userDTO;
    }

    //Actualizar Usuario
    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void actualizar(@RequestBody UsuarioDTO userDTO){
        ModelMapper m=new ModelMapper();
        Usuario user=m.map(userDTO,Usuario.class);
        iusuarioServices.actualizar(user);
    }

    //Eliminar Usuario
    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Long id){
        iusuarioServices.eliminar(id);
    }
}


