package es.grupo2.proyectospring.dto;

import es.grupo2.proyectospring.entity.Vendedor;

public class VendedorDTO {

    private Integer usuarioId;

    public VendedorDTO(){}

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
