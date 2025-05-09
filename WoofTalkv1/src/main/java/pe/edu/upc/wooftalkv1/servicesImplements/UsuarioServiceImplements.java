package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.entities.Usuario;
import pe.edu.upc.wooftalkv1.repositories.IUsuarioRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IUsuarioServices;

import java.util.List;
@Service
public class UsuarioServiceImplements implements IUsuarioServices {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Listar Usuario
    @Override
    public List<Usuario> listar() {return usuarioRepository.findAll();}

    //Registrar Usuario
    @Override
    //public Usuario registrar(Usuario usuario)
    public void registrar(Usuario usuario){
    String encriptacion = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encriptacion);
        usuarioRepository.save(usuario);
        }
   // {usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    //    usuarioRepository.save(usuario);}
    //{return usuarioRepository.save(usuario);}

    //Listar por Id Usuario
    @Override
    public Usuario listarId(Long id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    //Actualizar Usuario
    @Override
    public void actualizar(Usuario usuario) {usuarioRepository.save(usuario); }

    //Eliminar Usuario
    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarUsuarioTelefono(String telefono) { return usuarioRepository.buscarUsuarioPorTelefono(telefono); }

}
