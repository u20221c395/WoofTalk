package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;
import org.modelmapper.internal.bytebuddy.utility.nullability.MaybeNull;

@Entity
@Table(name="Mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "raza", length = 40, nullable = false)
    private String raza;

    @Column(name = "edad", length = 40, nullable = false)
    private int edad;

    @Column(name = "tamaño", length = 40, nullable = false)
    private String tamanio;

    @Column(name = "observaciones", length = 40, nullable = false)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCalificacion")
    private Calificacion calificacion;

    public Mascota() {
    }

    public Mascota(int id, String nombre, String raza, int edad, String tamanio, String observaciones, Usuario usuario, Calificacion calificacion) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamanio = tamanio;
        this.observaciones = observaciones;
        this.usuario = usuario;
        this.calificacion = calificacion;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
}

