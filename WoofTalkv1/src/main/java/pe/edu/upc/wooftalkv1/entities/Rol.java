package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name="TipoRol",length = 20,nullable = false )
    private String TipoRol;

    public Rol() {
    }

    public Rol(int id, String tipoRol) {
        this.id = id;
        TipoRol = tipoRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoRol() {
        return TipoRol;
    }

    public void setTipoRol(String tipoRol) {
        TipoRol = tipoRol;
    }
}
