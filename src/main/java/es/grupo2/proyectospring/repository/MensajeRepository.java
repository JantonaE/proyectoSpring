package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.Mensaje;

import es.grupo2.proyectospring.entity.VistaMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {


    @Query("select v from Mensaje v where v.destinatarioId= :id")
    public List<Mensaje> findByUsuarioId(int id);
}