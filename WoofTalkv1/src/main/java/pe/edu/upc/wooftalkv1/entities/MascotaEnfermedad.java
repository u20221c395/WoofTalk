package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MascotaEnfermedad")
public class MascotaEnfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idMascota")
    private Mascotas mascota;

    @ManyToOne
    @JoinColumn(name = "idEnfermedad")
    private Enfermedad enfermedad;

    public MascotaEnfermedad() {
    }

    public MascotaEnfermedad(int id, Mascotas mascota, Enfermedad enfermedad) {
        this.id = id;
        this.mascota = mascota;
        this.enfermedad = enfermedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mascotas getMascota() {
        return mascota;
    }

    public void setMascota(Mascotas mascota) {
        this.mascota = mascota;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }
}
