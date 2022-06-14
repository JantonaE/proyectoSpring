package es.grupo2.proyectospring.dto;

import es.grupo2.proyectospring.entity.Comprador;
import es.grupo2.proyectospring.entity.Usuario;

public class CompradorDTO {

    private Usuario usuario;
    private String categoriaPreferida;
    private Integer usuarioId;
    public CompradorDTO(){

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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


    public Comprador toNormal(){
        Comprador c=new Comprador();
        c.setUsuario(this.usuario);
        c.setCategoriaPreferida(this.categoriaPreferida);
        c.setUsuarioId(this.usuarioId);
        return c;
    }

}
