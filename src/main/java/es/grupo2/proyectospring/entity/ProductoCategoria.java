package es.grupo2.proyectospring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "producto_categoria", schema = "sql4483358", catalog = "")
public class ProductoCategoria {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id", nullable = false)
    private Integer productoId;
    @Basic
    @Column(name = "categoria_id", nullable = false)
    private Integer categoriaId;

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoCategoria that = (ProductoCategoria) o;
        return Objects.equals(productoId, that.productoId) && Objects.equals(categoriaId, that.categoriaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, categoriaId);
    }
}
