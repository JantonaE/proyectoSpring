package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.Analisis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Antonio Sepúlveda Zorrilla
 */
@Repository
public interface AnalisisRepository extends JpaRepository<Analisis, Integer> {
}
