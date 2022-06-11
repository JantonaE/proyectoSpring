package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.repository.ListaVentaRepository;
import es.grupo2.proyectospring.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lista_venta", schema = "sql4483358", catalog = "")
@IdClass(ListaVentaPK.class)
public class ListaVenta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vendedor_id", nullable = false)
    private Integer vendedorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "producto", nullable = false)
    private Integer producto;
    @Basic
    @Column(name = "comprador_id", nullable = true)
    private Integer compradorId;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "preciopuja", nullable = false, precision = 0)
    private Double preciopuja;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "producto", nullable = false)
    private Producto producto1;


    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "comprador_id", nullable = true)
    private Comprador comprador;

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Integer getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPreciopuja() {
        return preciopuja;
    }

    public void setPreciopuja(Double preciopuja) {
        this.preciopuja = preciopuja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaVenta that = (ListaVenta) o;
        return Objects.equals(vendedorId, that.vendedorId) && Objects.equals(producto, that.producto) && Objects.equals(compradorId, that.compradorId) && Objects.equals(fecha, that.fecha) && Objects.equals(preciopuja, that.preciopuja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendedorId, producto, compradorId, fecha, preciopuja);
    }
}
