package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Paseo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IPaseoRepository extends JpaRepository<Paseo, Integer>{
    public List<Paseo> findByFecha_inicio(LocalDate fecha_inicio);
}
