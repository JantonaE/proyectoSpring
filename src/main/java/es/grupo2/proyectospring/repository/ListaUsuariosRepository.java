package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.ListaUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Repository
public interface ListaUsuariosRepository extends JpaRepository<ListaUsuarios, Integer> {

    @Query ("select l from ListaUsuarios l where l.listaId = :idlista")
    public List<ListaUsuarios> findListaUsuariosByIDlista(int idlista);

    @Query ("select l from ListaUsuarios l where l.listaId = :idlista and l.usuarioId = :idUsuario")
    public ListaUsuarios findLista_Usuario(int idlista,int idUsuario);
}