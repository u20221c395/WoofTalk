package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Contrato;

    @Column(name = "Fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;

    @Column(name = "Fecha_fin", nullable = false)
    private LocalDate fecha_fin;

    @Column(name = "Monto", nullable = false)
    private double monto;

    @ManyToOne
    @JoinColumn(name = "Id_mascotas")
    private Mascotas mascotas;

    @ManyToOne
    @JoinColumn(name = "Id_MetodoPago")
    private MetodoPago metodoPago;

    public Contrato() {
    }

    public Contrato(int id_Contrato, LocalDate fecha_inicio, LocalDate fecha_fin, double monto, Mascotas mascotas, MetodoPago metodoPago) {
        this.id_Contrato = id_Contrato;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.monto = monto;
        this.mascotas = mascotas;
        this.metodoPago = metodoPago;
    }

    public int getId_Contrato() {
        return id_Contrato;
    }

    public void setId_Contrato(int id_Contrato) {
        this.id_Contrato = id_Contrato;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Mascotas getMascotas() {
        return mascotas;
    }

    public void setMascotas(Mascotas mascotas) {
        this.mascotas = mascotas;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
