package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.VendedorDTO;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Vendedor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "vendedor")
    private Set<ListaVenta> listaVentas = new LinkedHashSet<>();

    public Set<ListaVenta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(Set<ListaVenta> listaVentas) {
        this.listaVentas = listaVentas;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return Objects.equals(usuarioId, vendedor.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId);
    }

    public VendedorDTO toDTO() {
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setUsuarioId(this.usuarioId);
        return vendedorDTO;

    }
}
