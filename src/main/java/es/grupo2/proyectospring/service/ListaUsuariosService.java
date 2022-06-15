package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Lista;
import es.grupo2.proyectospring.entity.ListaUsuarios;
import es.grupo2.proyectospring.entity.Marketing;
import es.grupo2.proyectospring.entity.Usuario;
import es.grupo2.proyectospring.repository.ListaUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
    AUTHOR: Jesús Antona Espejo
*/
import java.util.List;

@Service
public class ListaUsuariosService {
    private ListaUsuariosRepository listaUsuariosRepository;

    @Autowired
    public void setListaUsuariosRepository(ListaUsuariosRepository listaUsuariosRepository) {
        this.listaUsuariosRepository = listaUsuariosRepository;
    }


    public void crearListaUsuarios (Integer id,Integer usuarioId) {
        ListaUsuarios lis = new ListaUsuarios();
        lis.setListaId(id);
        lis.setUsuarioId(usuarioId);
        this.listaUsuariosRepository.save(lis);
    }

    public void borrarUsuarioLista(Integer idLista,Integer idUsuario) {
        ListaUsuarios lista = this.listaUsuariosRepository.findLista_Usuario(idLista,idUsuario);
        this.listaUsuariosRepository.delete(lista);
    }
}
