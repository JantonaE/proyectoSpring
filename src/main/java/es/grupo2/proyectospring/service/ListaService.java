package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Lista;
import es.grupo2.proyectospring.entity.ListaUsuarios;
import es.grupo2.proyectospring.entity.Marketing;
import es.grupo2.proyectospring.entity.Usuario;
import es.grupo2.proyectospring.repository.ListaRepository;
import es.grupo2.proyectospring.repository.ListaUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaService {
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private ListaRepository listaRepository;
    private ListaUsuariosRepository listaUsuariosRepository;
    @Autowired
    public void setListaUsuariosRepository(ListaUsuariosRepository listaUsuariosRepository) {
        this.listaUsuariosRepository = listaUsuariosRepository;
    }

    @Autowired
    public void setListaRepository(ListaRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    public List<ListaDTO> listaEntityADTO (List<Lista> lista) {
        List<ListaDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Lista l:lista) {
                listaDTO.add(l.toDTO());
            }
        }
        return listaDTO;
    }

    public List<ListaDTO> listarListas () {
        List<Lista> lista = this.listaRepository.findAll();

        return this.listaEntityADTO(lista);
    }


    public ListaDTO buscarLista (long id) {
        Lista lista = this.listaRepository.findById((int) id).orElse(null);
        return lista.toDTO();
    }

    public void borrarLista (long id) {
        Lista lista = this.listaRepository.findById((int) id).orElse(null);
        if(lista==null) System.out.println("vacio");
        this.listaRepository.delete(lista);
    }


    private void rellenarLista (Lista lista, String descripcion, Marketing marketing,
                                List<UsuarioDTO> usuarioList) {
        lista.setDescripcion(descripcion);
        lista.setIdLista(lista.getIdLista());
        lista.setMarketingId(marketing.getUsuarioId());
        //lista.setUsuarioList(usuarioList);
    }

    public void crearLista (String descripcion,Marketing marketing,
                            List<UsuarioDTO> usuarioList) {
        Lista lista = new Lista();

        this.rellenarLista(lista,descripcion,marketing,usuarioList);

        this.listaRepository.save(lista);
    }

    public void modificarLista (long id, String descripcion, Marketing marketing,
                                List<UsuarioDTO> usuarioList) {
        Lista lista = this.listaRepository.findById((int) id).orElse(null);

        this.rellenarLista(lista,descripcion,marketing,usuarioList);

        this.listaRepository.save(lista);
    }

    private void rellenarListaUsuarios (List<ListaUsuarios> lista,
                                List<UsuarioDTO> usuarioList) {
        for(UsuarioDTO u : usuarioList){
            ListaUsuarios lu = new ListaUsuarios();
            lu.setListaId(lista.get(0).getListaId());
            lu.setUsuarioId(Math.toIntExact(u.getId()));
            this.listaUsuariosRepository.save(lu);
        }
    }

    public void modificarListaUsuarios (long id,
                                List<UsuarioDTO> usuarioList) {
        List<ListaUsuarios> lista = this.listaUsuariosRepository.findListaUsuariosByIDlista((int) id);

        this.rellenarListaUsuarios(lista,usuarioList);
        for (ListaUsuarios l : lista){
            this.listaUsuariosRepository.save(l);
        }

    }

}
