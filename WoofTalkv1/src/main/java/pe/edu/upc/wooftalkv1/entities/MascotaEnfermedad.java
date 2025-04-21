package pe.edu.upc.wooftalkv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "MascotaEnfermedad")
public class MascotaEnfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
