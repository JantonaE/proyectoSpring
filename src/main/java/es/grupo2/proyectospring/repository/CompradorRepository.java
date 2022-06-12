package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.dto.CompradorDTO;
import es.grupo2.proyectospring.entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador,Integer> {

    @Query("select c from Comprador c where c.usuarioId=:id")
    public Comprador findByIDComprador(int id);
}
