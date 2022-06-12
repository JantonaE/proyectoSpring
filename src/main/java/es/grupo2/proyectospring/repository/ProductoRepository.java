package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {


    @Query("select p from Producto p where p.id=:id")
    public Producto findByIdP(int id);
}
