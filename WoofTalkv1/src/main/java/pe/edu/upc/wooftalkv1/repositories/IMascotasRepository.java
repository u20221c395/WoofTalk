package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.entities.Mascotas;

@Repository
public interface IMascotasRepository extends JpaRepository<Mascotas, Integer>{

      @Query("SELECT m FROM Mascotas m WHERE m.edad > 10")
    List<Mascotas> Mascotasconedadmasde10();

      @Query("SELECT new pe.edu.upc.wooftalkv1.DTOS.MascotasporDuenoDTO(CONCAT(u.nombre, ' ', u.apellido), COUNT(m)) " +
            "FROM Mascotas m JOIN m.usuario u GROUP BY u.nombre, u.apellido")
    public List<MascotasporDuenoDTO> mascotastotalporDueno();
}
