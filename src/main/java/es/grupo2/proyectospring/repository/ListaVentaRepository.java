package es.grupo2.proyectospring.repository;

import es.grupo2.proyectospring.entity.ListaVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaVentaRepository extends JpaRepository<ListaVenta, Integer> {

    @Query("SELECT lv FROM ListaVenta lv WHERE lv.vendedorId = :id")
    public List<ListaVenta> findListaVentaByVendedorId(int id);

    @Query("SELECT lv FROM ListaVenta lv WHERE lv.producto = :id")
    public ListaVenta findListaVentaByProductoId(int id);

    @Query("SELECT lv FROM ListaVenta lv WHERE lv.vendedorId = :idV AND lv.producto = :idP")
    public ListaVenta findByVendedorAndProducto(int idV, int idP);

    @Query("SELECT lv FROM ListaVenta lv WHERE lv.comprador.usuario.nombre LIKE :c OR lv.producto1.titulo LIKE :producto AND lv.preciopuja < :p ORDER BY lv.preciopuja DESC ")
    public List<ListaVenta> findByfiltro(double p, String c, String producto);

    @Query("SELECT lv FROM ListaVenta lv WHERE lv.producto1.titulo LIKE :producto AND lv.preciopuja < :p ORDER BY lv.preciopuja DESC ")
    public List<ListaVenta> findByProducto(double p, String producto);

    @Query("select lv from ListaVenta lv where lv.producto1.titulo like :nombre")
    public List<ListaVenta> findByNombre(String nombre);

    @Query("select lv from ListaVenta lv where lv.producto1.descripcion like :desc")
    public List<ListaVenta> findByDescripcion(String desc);

    @Query("select lv from ListaVenta lv where lv.preciopuja = :precio")
    public List<ListaVenta> findByPrecio( double precio);

    @Query("select lv from ListaVenta lv where lv.producto1.categoriaProducto = :categoria")
    public List<ListaVenta> findByCategoria(int categoria);
    
}
