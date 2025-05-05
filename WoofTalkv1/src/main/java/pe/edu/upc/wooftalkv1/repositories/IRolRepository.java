package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Rol;

import java.util.List;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = " SELECT COUNT(*) \n" +
            " FROM usuario\n" +
            " WHERE rol_id = 2;",nativeQuery = true)

    public List<String[]> cantidadTotalDeRolUsuariosRegistrados();
}
