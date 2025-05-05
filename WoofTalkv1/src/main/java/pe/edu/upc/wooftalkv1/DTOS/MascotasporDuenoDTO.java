package pe.edu.upc.wooftalkv1.DTOS;

public class MascotasporDuenoDTO {

    private String dueno;
    private Long mascota;

    public MascotasporDuenoDTO() {
    }

    public MascotasporDuenoDTO(String dueno, Long mascota) {
        this.dueno = dueno;
        this.mascota = mascota;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public Long getMascota() {
        return mascota;
    }

    public void setMascota(Long mascota) {
        this.mascota = mascota;
    }

}
