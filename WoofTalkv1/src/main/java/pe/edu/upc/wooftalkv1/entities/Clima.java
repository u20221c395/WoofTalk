package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Clima")
public class Clima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClima;

    @Column(name = "Temperatura", nullable = false)
    private int temperatura;

    @Column(name = "Humedad", nullable = false)
    private int humedad;

    @Column(name = "Condicion", nullable = false)
    private int condicion;

    public Clima() {
    }

    public Clima(int idClima, int temperatura, int humedad, int condicion) {
        this.idClima = idClima;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.condicion = condicion;
    }

    public int getIdClima() {
        return idClima;
    }

    public void setIdClima(int idClima) {
        this.idClima = idClima;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}
