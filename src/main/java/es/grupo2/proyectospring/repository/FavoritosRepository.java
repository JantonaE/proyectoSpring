package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.entity.FavoritosComprador;
import es.grupo2.proyectospring.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritosRepository extends JpaRepository<FavoritosComprador,Integer> {

    @Query("select p from FavoritosComprador p where p.compradorId=:idcomprador")
    public List<FavoritosComprador> favoritos(int idcomprador);

    @Query("select f from FavoritosComprador f where f.compradorId=:idc and f.productoId=:idp")
    public FavoritosComprador findByIDC(int idc,int idp);

}
