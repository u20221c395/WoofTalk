package pe.edu.upc.wooftalkv1.DTOS;

import pe.edu.upc.wooftalkv1.entities.MetodoPago;
import pe.edu.upc.wooftalkv1.entities.Usuario;

import java.time.LocalDate;

public class SolicitudDTO {

    private int id;

    private LocalDate fecha;

    private Usuario usuario;

    private MetodoPago metodoPago;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
