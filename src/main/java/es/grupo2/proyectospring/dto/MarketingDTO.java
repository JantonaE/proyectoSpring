package es.grupo2.proyectospring.dto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;


/**
 *
 * @author Jesús Antona Espejo
 */
public class MarketingDTO{

    private Long usuarioId;

    private List<ListaDTO> listaList;

    private UsuarioDTO usuario;

    public MarketingDTO() {
    }


    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ListaDTO> getListaList() {
        return listaList;
    }

    public void setListaList(List<ListaDTO> listaList) {
        this.listaList = listaList;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MarketingDTO)) {
            return false;
        }
        MarketingDTO other = (MarketingDTO) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tawebay.dto.MarketingDTO[ usuarioId=" + usuarioId + " ]";
    }

}
