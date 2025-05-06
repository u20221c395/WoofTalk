package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Paseo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPaseoRepository extends JpaRepository<Paseo, Integer>{
    @Query("SELECT p FROM Paseo p WHERE p.fecha_inicio = :fechaInicio")
    List<Paseo> buscarPaseosPorFecha(@Param("fechaInicio") LocalDate fechaInicio);
}
