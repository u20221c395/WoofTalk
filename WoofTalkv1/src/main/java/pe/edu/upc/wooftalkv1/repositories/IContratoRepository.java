package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Contrato;

import java.util.List;

@Repository
public interface IContratoRepository extends JpaRepository<Contrato, Integer> {
    @Query("SELECT c FROM Contrato c WHERE c.mascotas.id = :mascotaId")
    List<Contrato> buscarContratosPorIdMascota(@Param("mascotaId") Integer mascotaId);

}
