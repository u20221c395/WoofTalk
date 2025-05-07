package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.wooftalkv1.entities.Recomendacion;

public interface IRecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
}
