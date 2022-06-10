package es.grupo2.proyectospring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ListaUsuariosPK implements Serializable {
    @Column(name = "usuario_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;
    @Column(name = "lista_id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        ListaUsuariosPK that = (ListaUsuariosPK) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(listaId, that.listaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, listaId);
    }
}
