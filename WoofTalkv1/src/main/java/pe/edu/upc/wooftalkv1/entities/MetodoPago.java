package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MetodoPago")
public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre", length = 20 , nullable = false)
    private String nombre;

    @Column(name = "Descripcion", length = 40 , nullable = false)
    private String descripcion;

    @Column(name = "Estado", length = 40 , nullable = false)
    private String estado;

    public MetodoPago() {
    }

    public MetodoPago(int id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
