package pe.edu.upc.wooftalkv1.DTOS;

public class BuscarMascotaTamanioDTO {
    private String NombreMascota;
    private String TamanioMascota;

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        NombreMascota = nombreMascota;
    }

    public String getTamanioMascota() {
        return TamanioMascota;
    }

    public void setTamanioMascota(String tamanioMascota) {
        TamanioMascota = tamanioMascota;
    }
}
