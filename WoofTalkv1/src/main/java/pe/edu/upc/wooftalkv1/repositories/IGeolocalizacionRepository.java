package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Geolocalizacion;

@Repository
public interface IGeolocalizacionRepository extends CrudRepository<Geolocalizacion, Integer> {
}
