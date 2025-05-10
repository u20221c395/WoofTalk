package pe.edu.upc.wooftalkv1.DTOS;

import java.time.LocalDate;
import java.util.Date;

public class BuscarContratoDTO {
    private int id_Contrato;
    private LocalDate fecha_fin;
    private double monto;

    public int getId_Contrato() {
        return id_Contrato;
    }

    public void setId_Contrato(int id_Contrato) {
        this.id_Contrato = id_Contrato;
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
}
