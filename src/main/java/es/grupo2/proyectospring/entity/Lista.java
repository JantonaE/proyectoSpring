package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Lista {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_lista", nullable = false)
    private Integer idLista;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic
    @Column(name = "marketing_id", nullable = false)
    private Integer marketingId;

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getMarketingId() {
        return marketingId;
    }

    public void setMarketingId(Integer marketingId) {
        this.marketingId = marketingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return Objects.equals(idLista, lista.idLista) && Objects.equals(descripcion, lista.descripcion) && Objects.equals(marketingId, lista.marketingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLista, descripcion, marketingId);
    }

    public ListaDTO toDTO() {
        ListaDTO dto = new ListaDTO();
        dto.setDescripcion(descripcion);
        dto.setIdLista(Long.valueOf(idLista));
        dto.setMarketingId(marketingId);
        //dto.setUsuarioList(usuarioEntityADTO(usuarioList));

        return dto;
    }

    public List<UsuarioDTO> usuarioEntityADTO (List<Usuario> lista) {
        List<UsuarioDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Usuario u:lista) {
                listaDTO.add(u.toDTO());
            }
        }
        return listaDTO;
    }
}
