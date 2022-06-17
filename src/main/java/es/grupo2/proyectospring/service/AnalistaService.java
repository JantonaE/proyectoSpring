package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.dto.AnalistaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Analista;
import es.grupo2.proyectospring.repository.AnalistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalistaService {

    private AnalistaRepository analistaRepository;

    public AnalistaRepository getAnalistaRepository() {
        return analistaRepository;
    }
    private UsuarioService usuarioService;
    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
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

    public List<UsuarioDTO> listarAnalistas () {
        List<Analista> clientes = analistaRepository.findAll();
        List<UsuarioDTO> us = new ArrayList<>();
        for(Analista an : clientes){
            UsuarioDTO u = usuarioService.buscarUsuario(an.getUsuarioId());
            us.add(u);}
        return us;
    }

    public List<UsuarioDTO> listarNOAnalistas(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios(null);
        List<UsuarioDTO> analistas = this.listarAnalistas();
        List<UsuarioDTO> aux = new ArrayList<>();
        for(UsuarioDTO us : usuarios){
            boolean encontrado = false;
            for(UsuarioDTO an : analistas){
                if(an.getId() == us.getId()){
                    encontrado = true;
                }
            }
            if(!encontrado){
                aux.add(us);
            }
        }
        return aux;
    }

    public void borrarAnalista (int id) {
        Analista m= this.analistaRepository.findById(id).orElse(null);
        this.analistaRepository.delete(m);
    }

    public void guardarAnalista(AnalistaDTO an){
        Analista analista = new Analista();
        analista.setUsuarioId(an.getUsuarioId());
        this.analistaRepository.save(analista);
    }


}
