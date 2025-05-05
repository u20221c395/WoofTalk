package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Enfermedad;

import java.util.List;

@Repository
public interface IEnfermedadRepository extends JpaRepository<Enfermedad, Integer> {
    @Query(value = " SELECT e.\"nombre enfermedad\" AS nombre_enfermedad, m.nombre AS nombre_mascota " +
            " FROM Enfermedad e " +
            " JOIN Mascota_Enfermedad me ON e.id_enfermedad = me.id_enfermedad " +
            " JOIN Mascotas m ON me.id_mascota = m.id " +
            " WHERE e.\"nombre enfermedad\" = :name", nativeQuery = true)
    List<String[]> buscarMascotasPorEnfermedad(@Param("name") String name);

}
