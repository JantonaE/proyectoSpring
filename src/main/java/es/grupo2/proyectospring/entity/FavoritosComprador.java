package es.grupo2.proyectospring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favoritos_comprador", schema = "sql4483358", catalog = "")
@IdClass(FavoritosCompradorPK.class)
public class FavoritosComprador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comprador_id", nullable = false)
    private Integer compradorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto_id", nullable = false)
    private Integer productoId;

    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoritosComprador that = (FavoritosComprador) o;
        return Objects.equals(compradorId, that.compradorId) && Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compradorId, productoId);
    }
}
