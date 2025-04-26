package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.wooftalkv1.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findOneByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String name);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, usuario_id) VALUES (:rol, :usuario_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("usuario_id") Long usuario_id);

}
