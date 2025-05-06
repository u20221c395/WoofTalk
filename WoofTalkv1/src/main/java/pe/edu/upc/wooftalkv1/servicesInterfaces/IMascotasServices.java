package pe.edu.upc.wooftalkv1.servicesInterfaces;

import pe.edu.upc.wooftalkv1.DTOS.MascotasporDuenoDTO;
import pe.edu.upc.wooftalkv1.entities.Clima;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.entities.MetodoPago;

import java.util.List;

public interface IMascotasServices {
    public List<Mascotas> list();
    public void insert(Mascotas mascotas);
    public void update(Mascotas mascotas);
    public Mascotas listarId(int id);
    public void delete(int id);
    public List<Mascotas> Mascotasconedadmasde10();
    List<MascotasporDuenoDTO> MascotasporDueno();
    public List<Mascotas> mascotasPorRaza();
    public List<Mascotas> buscarPorTamanio(String tamanio);
}
