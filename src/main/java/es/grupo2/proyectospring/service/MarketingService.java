package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.repository.MarketingRepository;
import es.grupo2.proyectospring.dto.MarketingDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Marketing;
import es.grupo2.proyectospring.repository.MarketingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketingService {
    private MarketingRepository marketingRepository;
    private UsuarioService usuarioService;

    @Autowired
    public void setMarketingRepository(MarketingRepository marketingRepository){
        this.marketingRepository = marketingRepository;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public List<UsuarioDTO> listarMarketing () {
        List<Marketing> clientes = marketingRepository.findAll();
        List<UsuarioDTO> us = new ArrayList<>();
        for(Marketing an : clientes){
            UsuarioDTO u = usuarioService.buscarUsuario(an.getUsuarioId());
            us.add(u);}
        return us;
    }

    public List<UsuarioDTO> listarNOMarketing(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios(null);
        List<UsuarioDTO> analistas = this.listarMarketing();
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

    public MarketingDTO buscarMarketing (int id) {
        Marketing m = this.marketingRepository.findById(id).orElse(null);
        return m.toDTO();
    }

    public void borrarMarketing (int id) {
        Marketing m= this.marketingRepository.findById(id).orElse(null);
        this.marketingRepository.delete(m);
    }

    public void guardarMarketing(Integer id) {
        Marketing m = new Marketing();
        m.setUsuarioId(id);
        this.marketingRepository.save(m);
    }

}
