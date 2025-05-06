package pe.edu.upc.wooftalkv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.wooftalkv1.DTOS.MascotasporDuenoDTO;
import pe.edu.upc.wooftalkv1.entities.Mascotas;

import java.util.List;

@Repository
public interface IMascotasRepository extends JpaRepository<Mascotas, Integer>{

      @Query(" SELECT m FROM Mascotas m WHERE m.edad > 10 ")
    public List<Mascotas> Mascotasconedadmasde10();

      @Query("SELECT new pe.edu.upc.wooftalkv1.DTOS.MascotasporDuenoDTO(CONCAT(u.nombre, ' ', u.apellido), COUNT(m)) " +
            "FROM Mascotas m JOIN m.usuario u GROUP BY u.nombre, u.apellido")
    public List<MascotasporDuenoDTO> mascotastotalporDueno();

      //Cantidad de mascotas por raza
      @Query(value = "SELECT m.raza as Razas, COUNT(*) as CANTIDAD\n" +
              "FROM mascotas m \n" +
              "GROUP BY m.raza",nativeQuery = true)
    public List<Mascotas> mascotasPorRaza();

      @Query(value = "Select m.nombre as Nombre_mascota\n" +
              "FROM mascotas m\n" +
              "WHERE m.tamanio = :tamanio",nativeQuery = true)
    public List<Mascotas> buscarPorTamañoMascota(@Param("tamanio") String tamanio);
}
