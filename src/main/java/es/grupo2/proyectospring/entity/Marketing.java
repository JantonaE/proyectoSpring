package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.MarketingDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/*
    AUTHOR: Jesús Antona Espejo
*/
@Entity
public class Marketing {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marketing marketing = (Marketing) o;
        return Objects.equals(usuarioId, marketing.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId);
    }

    public MarketingDTO toDTO() {
        MarketingDTO dto = new MarketingDTO();
        //dto.setUsuario(usuarioId);
        dto.setUsuarioId(Long.valueOf(usuarioId));
        return dto;
    }

    public List<ListaDTO> listaEntityADTO (List<Lista> lista) {
        List<ListaDTO> listaDTO = null;
        if (lista != null) {
            listaDTO = new ArrayList<>();
            for (Lista l:lista) {
                listaDTO.add(l.toDTO());
            }
        }
        return listaDTO;
    }

}
