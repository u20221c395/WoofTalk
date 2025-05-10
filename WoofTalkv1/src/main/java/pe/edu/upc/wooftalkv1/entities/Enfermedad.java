package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Enfermedad")
public class Enfermedad {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdEnfermedad;

   @Column(name = "Nombre Enfermedad", nullable = false ,length = 100)
    private String nombreEnfermedadzzzz;

    @Column(name = "Descripcion de la enfermedad", nullable = false ,length = 200)
    private String descripcionEnfermedad;

    public Enfermedad() {
    }

    public Enfermedad(int idEnfermedad, String nombreEnfermedad, String descripcionEnfermedad) {
        IdEnfermedad = idEnfermedad;
        this.nombreEnfermedad = nombreEnfermedad;
        this.descripcionEnfermedad = descripcionEnfermedad;
    }

    public int getIdEnfermedad() {
        return IdEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        IdEnfermedad = idEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getDescripcionEnfermedad() {
        return descripcionEnfermedad;
    }

    public void setDescripcionEnfermedad(String descripcionEnfermedad) {
        this.descripcionEnfermedad = descripcionEnfermedad;
    }
}


