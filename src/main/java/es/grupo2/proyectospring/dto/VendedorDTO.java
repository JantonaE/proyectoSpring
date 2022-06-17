package es.grupo2.proyectospring.dto;

import es.grupo2.proyectospring.entity.Comprador;
import es.grupo2.proyectospring.entity.Vendedor;
import es.grupo2.proyectospring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VendedorDTO {

    private Integer usuarioId;
    private UsuarioRepository usuarioRepository;

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

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Vendedor toNormal(){
        Vendedor v = new Vendedor();
        v.setUsuarioId(this.usuarioId);
        return v;
    }
}
