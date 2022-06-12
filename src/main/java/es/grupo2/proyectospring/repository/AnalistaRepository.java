package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.Analista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalistaRepository extends JpaRepository<Analista, Integer> {
}
