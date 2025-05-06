package pe.edu.upc.wooftalkv1.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.wooftalkv1.DTOS.*;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IMascotasServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mascotas")
public class MascotasController {

    @Autowired
    private IMascotasServices mS;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<MascotasDTO> listar(){
        return mS.list().stream().map( x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,MascotasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void agregar(@RequestBody MascotasDTO mascotasDTO){
        ModelMapper m = new ModelMapper();
        Mascotas ma = m.map(mascotasDTO,Mascotas.class);
        mS.insert(ma);
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody MascotasDTO mascotasDTO){
        ModelMapper m = new ModelMapper();
        Mascotas ma = m.map(mascotasDTO,Mascotas.class);
        mS.update(ma);
    }

    @GetMapping("/buscarporid/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public MascotasDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        MascotasDTO mascotasDTO = m.map(mS.listarId(id), MascotasDTO.class);
        return mascotasDTO;
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") int id){
        mS.delete(id);
    }

        @GetMapping("/mascotasconedadmasde10")
    public List<MascotasDTO> edadsmasde10(){
        return mS.Mascotasconedadmasde10().stream().map(x->{
            ModelMapper mmm=new ModelMapper();
            return mmm.map(x,MascotasDTO.class);
        }).collect(Collectors.toList());
    }

        @GetMapping("/mascotasporDueno")
    public List<MascotasporDuenoDTO> mascotasporDueno() {
        return mS.MascotasporDueno();
    }

    @GetMapping("/razasdemascotas")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<RazaMascotaDTO> mascotasPorRaza() {
        return mS.mascotasPorRaza().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x,RazaMascotaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/mascotasPorTamaño")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public List<BuscarMascotaTamanioDTO> listarMascotasPorTamanio(@RequestParam String tamanio){
        return mS.buscarPorTamanio(tamanio).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x,BuscarMascotaTamanioDTO.class);
        }).collect(Collectors.toList());
    }

}

