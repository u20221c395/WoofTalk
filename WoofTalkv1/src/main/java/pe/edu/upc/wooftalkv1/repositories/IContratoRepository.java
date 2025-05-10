package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Contrato;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {

    @Query("SELECT c FROM Contrato c WHERE c.fecha_inicio = :fecha_inicio")
    List<Contrato> buscarContratosFechaInicio(@Param("fecha_inicio") LocalDate fecha_inicio);

    @Query("SELECT c FROM Contrato c WHERE c.monto = :Monto")
    List<Contrato> buscarContratosPorMonto(@Param("Monto") Double Monto);
}
