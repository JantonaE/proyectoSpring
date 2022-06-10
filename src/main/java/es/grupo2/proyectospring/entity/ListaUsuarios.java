package es.grupo2.proyectospring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lista_usuarios", schema = "sql4483358", catalog = "")
@IdClass(ListaUsuariosPK.class)
public class ListaUsuarios {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lista_id", nullable = false)
    private Integer listaId;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaUsuarios that = (ListaUsuarios) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(listaId, that.listaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, listaId);
    }
}
