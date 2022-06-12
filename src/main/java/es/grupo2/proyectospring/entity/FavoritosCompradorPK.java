package es.grupo2.proyectospring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FavoritosCompradorPK implements Serializable {
    @Column(name = "comprador_id", nullable = false)
    @Id

    private Integer compradorId;
    @Column(name = "producto_id", nullable = false)
    @Id

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
        FavoritosCompradorPK that = (FavoritosCompradorPK) o;
        return Objects.equals(compradorId, that.compradorId) && Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compradorId, productoId);
    }
}
