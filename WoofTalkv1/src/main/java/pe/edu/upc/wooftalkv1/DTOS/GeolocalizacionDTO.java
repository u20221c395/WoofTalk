package pe.edu.upc.wooftalkv1.DTOS;

import pe.edu.upc.wooftalkv1.entities.Clima;

import java.time.LocalDate;

public class GeolocalizacionDTO {
    private int id;

    private int latitud;
    private int longitud;
    private LocalDate fecha;
    private Clima clima;

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
