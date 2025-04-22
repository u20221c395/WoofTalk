package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Paseo;

@Repository
public interface IPaseoRepository extends JpaRepository<Paseo, Integer>{
}
