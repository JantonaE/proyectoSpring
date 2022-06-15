package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
}