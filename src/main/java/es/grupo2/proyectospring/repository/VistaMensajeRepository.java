package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.VistaMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Repository
public interface VistaMensajeRepository extends JpaRepository<VistaMensaje, Integer> {

    @Query ("select v from VistaMensaje v where v.destinatarioId = :id")
    public List<VistaMensaje> findByUsuarioId(int id);
}