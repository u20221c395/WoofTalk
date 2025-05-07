package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Solicitud;

@Repository
public interface ISolicitudRepository extends JpaRepository<Solicitud, Integer> {
}
