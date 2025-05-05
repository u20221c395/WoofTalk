package pe.edu.upc.wooftalkv1.DTOS;

public class BuscarPorMascotaDTO {
    private String NombreEnfermedad;
    private String NombreMascota;

    public String getNombreEnfermedad() {
        return NombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        NombreEnfermedad = nombreEnfermedad;
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        NombreMascota = nombreMascota;
    }
}
