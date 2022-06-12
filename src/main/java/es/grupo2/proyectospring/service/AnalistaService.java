package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.entity.Analista;
import es.grupo2.proyectospring.repository.AnalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalistaService {

    private AnalistaRepository analistaRepository;

    public AnalistaRepository getAnalistaRepository() {
        return analistaRepository;
    }

    @Autowired
    public void setAnalistaRepository(AnalistaRepository analistaRepository) {
        this.analistaRepository = analistaRepository;
    }

    public Analista findById(String id){
        if(id==null || id.equals("")){
            return null;
        }
        Integer idInt = Integer.parseInt(id);

        return analistaRepository.findById(idInt).orElse(null);
    }
}
