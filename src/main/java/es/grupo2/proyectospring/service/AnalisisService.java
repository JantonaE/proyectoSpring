package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.entity.Analisis;
import es.grupo2.proyectospring.repository.AnalisisRepository;
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

    public Analisis findById(String id){
        if(id==null || id.equals("")){
            return null;
        }
        Integer idInt = Integer.parseInt(id);

        return analisisRepository.findById(idInt).orElse(null);
    }

}
