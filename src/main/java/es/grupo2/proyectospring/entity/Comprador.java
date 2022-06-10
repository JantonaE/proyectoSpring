package es.grupo2.proyectospring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Comprador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;
    @Basic
    @Column(name = "categoria_preferida", nullable = true, length = 50)
    private String categoriaPreferida;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCategoriaPreferida() {
        return categoriaPreferida;
    }

    public void setCategoriaPreferida(String categoriaPreferida) {
        this.categoriaPreferida = categoriaPreferida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprador comprador = (Comprador) o;
        return Objects.equals(usuarioId, comprador.usuarioId) && Objects.equals(categoriaPreferida, comprador.categoriaPreferida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, categoriaPreferida);
    }
}
