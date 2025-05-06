package pe.edu.upc.wooftalkv1.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.wooftalkv1.DTOS.MascotasporDuenoDTO;
import pe.edu.upc.wooftalkv1.entities.Mascotas;
import pe.edu.upc.wooftalkv1.repositories.IMascotasRepository;
import pe.edu.upc.wooftalkv1.servicesInterfaces.IMascotasServices;

import java.util.List;
@Service
public class MascotasServiceImplement implements IMascotasServices {
    @Autowired
    private IMascotasRepository mR;

    @Override
    public List<Mascotas> list() {
        return mR.findAll();
    }
    @Override
    public void insert(Mascotas mascotas) {
        mR.save(mascotas);
    }

    @Override
    public void update(Mascotas mascotas) {
        mR.save(mascotas);
    }

    @Override
    public Mascotas listarId(int id) {
        return mR.findById(id).orElse(new Mascotas());
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

        @Override
    public List<Mascotas> Mascotasconedadmasde10() {
        return mR.Mascotasconedadmasde10();
    }

       @Override
    public List<MascotasporDuenoDTO> MascotasporDueno() {
        return mR.mascotastotalporDueno();
    }

    @Override
    public List<Mascotas> mascotasPorRaza(){
        return mR.mascotasPorRaza();
    }

    @Override
    public List<Mascotas> buscarPorTamanio(String tamanio) {
        return mR.buscarPorTamañoMascota(tamanio);
    }
}
