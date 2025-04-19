package pe.edu.upc.wooftalkv1.DTOS;

import jakarta.persistence.Column;

public class EnfermedadDTO {
    private int IdEnfermedad;


    private String nombreEnfermedad;


    private String descripcionEnfermedad;

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
