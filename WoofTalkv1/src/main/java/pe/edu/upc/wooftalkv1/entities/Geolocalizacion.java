package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Geolocalizacion")

public class Geolocalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Latitud", nullable = false)
    private double latitud;

    @Column(name = "Longuitud", nullable = false)
    private double longitud;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "idClima")
    private Clima clima;

    public Geolocalizacion() {
    }

    public Geolocalizacion(int id, double latitud, double longitud, Date fecha, Clima clima) {
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

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Clima getClima() {
        return clima;
    }

    public void setClima(Clima clima) {
        this.clima = clima;
    }
}
