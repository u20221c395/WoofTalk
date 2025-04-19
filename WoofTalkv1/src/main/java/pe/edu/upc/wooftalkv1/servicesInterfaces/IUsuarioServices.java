package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.entities.Usuario;

import java.util.List;

public interface IUsuarioServices {

    //Listar Usuario
    public List<Usuario> listar();

    //Registrar Usuario
    public Usuario registrar(Usuario usuario);

    //Listar por Id Usuario
    public Usuario listarId(Long id);

    //Actualizar Usuario
    public void actualizar(Usuario usuario);

    //Eliminar Usuario
    void eliminar(Long id);
}
