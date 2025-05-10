package pe.edu.upc.wooftalkv1.DTOS;

import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.entities.MetodoPago;

import java.time.LocalDate;
import java.util.Date;

public class ContratoDTO {
    private int id_Contrato;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private double monto;
    private Mascotas mascotas;
    private MetodoPago metodoPago;

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
