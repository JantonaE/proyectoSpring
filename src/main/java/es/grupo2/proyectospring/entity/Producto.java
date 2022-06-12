package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.MensajeDTO;
import es.grupo2.proyectospring.dto.ProductoDTO;
import es.grupo2.proyectospring.dto.VendedorDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Producto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic
    @Column(name = "precio_salida", nullable = false, precision = 2)
    private BigDecimal precioSalida;
    @Basic
    @Column(name = "URL_foto", nullable = false, length = 100)
    private String urlFoto;
    @Basic
    @Column(name = "categoria_producto", nullable = false)
    private Integer categoriaProducto;

    @OneToMany(mappedBy = "producto1")
    private Set<ListaVenta> listaVentas = new LinkedHashSet<>();

    public Set<ListaVenta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(Set<ListaVenta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioSalida() {
        return precioSalida;
    }

    public void setPrecioSalida(BigDecimal precioSalida) {
        this.precioSalida = precioSalida;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Integer getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(Integer categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals(titulo, producto.titulo) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(precioSalida, producto.precioSalida) && Objects.equals(urlFoto, producto.urlFoto) && Objects.equals(categoriaProducto, producto.categoriaProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descripcion, precioSalida, urlFoto, categoriaProducto);
    }


    public ProductoDTO toDTO() {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(getId());
        dto.setCategoriaProducto(getCategoriaProducto());
        dto.setDescripcion(getDescripcion());
        dto.setTitulo(getTitulo());
        dto.setPrecioSalida(getPrecioSalida());
        dto.setUrlFoto(getUrlFoto());
        return dto;
    }

}
