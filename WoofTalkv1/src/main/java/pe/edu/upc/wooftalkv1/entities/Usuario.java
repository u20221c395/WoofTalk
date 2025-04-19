package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario", length = 30, unique = true)
    private String usuario;

    @Column(name = "contrasena", length = 50)
    private String contrasena;

    @Column(name = "nombre", length = 10, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 10, nullable = false)
    private String apellido;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "calificacion_id")
    private Calificacion calificacion;

    public Usuario() {
    }

    public Usuario(Long id, String usuario, String contrasena, String apellido, String nombre, String telefono, Rol rol, Calificacion calificacion) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rol = rol;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
}