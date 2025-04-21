package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Geolocalizacion")
public class Geolocalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "latitud", nullable = false)
    private int latitud;

    @Column(name = "longitud", nullable = false)
    private int longitud;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idClima")
    private Clima clima;

    public Geolocalizacion() {
    }

    public Geolocalizacion(int id, int latitud, int longitud, LocalDate fecha, Clima clima) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
        this.clima = clima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }
}
