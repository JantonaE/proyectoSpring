package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.entity.Analisis;
import es.grupo2.proyectospring.entity.Analista;
import es.grupo2.proyectospring.repository.AnalisisRepository;
import es.grupo2.proyectospring.repository.AnalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalisisService {

    private AnalisisRepository analisisRepository;

    public AnalisisRepository getAnalisisRepository() {
        return analisisRepository;
    }

    @Autowired
    public void setAnalisisRepository(AnalisisRepository analisisRepository) {
        this.analisisRepository = analisisRepository;
    }

    private AnalistaRepository analistaRepository;

    public AnalistaRepository getAnalistaRepository() {
        return analistaRepository;
    }

    @Autowired
    public void setAnalistaRepository(AnalistaRepository analistaRepository) {
        this.analistaRepository = analistaRepository;
    }

    public Analisis findById(String id){
        if(id==null || id.equals("")){
            return null;
        }
        Integer idInt = Integer.parseInt(id);

        return analisisRepository.findById(idInt).orElse(null);
    }

    public void crearAnalisis(String nombreAnalisis, String idanalista, String nombre, String apellidos, String domicilio, String ciudad, String edad, String sexo, String orden) {
        Analisis analisis = new Analisis();

        Analista analista = analistaRepository.findById(Integer.parseInt(idanalista)).orElse(null);

        rellenarCampos(analisis, analista, nombreAnalisis, nombre, apellidos, domicilio, ciudad, edad, sexo, orden);

        analista.getAnalisesByUsuarioId().add(analisis);

        analisisRepository.save(analisis);
        analistaRepository.save(analista);
    }

    private void rellenarCampos(Analisis analisis, Analista analista, String nombreAnalisis, String nombre, String apellidos, String domicilio, String ciudad, String edad, String sexo, String orden) {

        analisis.setNombre(nombreAnalisis);

        analisis.setAnalistaByAnalistaId(analista);

        String busqueda = "filtroNombre="+nombre+"&"
                + "filtroApellido="+apellidos+"&"
                + "filtroDomicilio="+domicilio+"&"
                + "filtroCiudad="+ciudad+"&"
                + "filtroEdad="+edad+"&"
                + "Sexo="+sexo+"&"
                + "Ordenar="+orden;
        analisis.setBusqueda(busqueda);
    }

    public void actualizarAnalisis(String id, String idanalista, String nombreAnalisis, String nombre, String apellidos, String domicilio, String ciudad, String edad, String sexo, String orden) {
        Analisis analisis = analisisRepository.findById(Integer.parseInt(id)).orElse(null);

        Analista analista = analistaRepository.findById(Integer.parseInt(idanalista)).orElse(null);

        rellenarCampos(analisis, analista, nombreAnalisis, nombre, apellidos, domicilio, ciudad, edad, sexo, orden);

        analisisRepository.save(analisis);
    }

    public void copiarAnalisis(String id){
        Analisis modelo = analisisRepository.findById(Integer.parseInt(id)).orElse(null);
        Analisis analisis = new Analisis();

        analisis.setAnalistaByAnalistaId(modelo.getAnalistaByAnalistaId());
        analisis.setNombre(modelo.getNombre()+" - copia");
        analisis.setBusqueda(modelo.getBusqueda());

        modelo.getAnalistaByAnalistaId().getAnalisesByUsuarioId().add(analisis);
        analisisRepository.save(analisis);
        analistaRepository.save(modelo.getAnalistaByAnalistaId());
    }

    public void borrarAnalisis(String id){
        Analisis analisis = analisisRepository.findById(Integer.parseInt(id)).orElse(null);
        Analista analista = analisis.getAnalistaByAnalistaId();
        analista.getAnalisesByUsuarioId().remove(analisis);

        analisisRepository.delete(analisis);
        analistaRepository.save(analista);
    }

}
