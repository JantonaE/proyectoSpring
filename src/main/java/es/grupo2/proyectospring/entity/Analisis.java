package es.grupo2.proyectospring.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Analisis {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
    private String descripcion;
    @Basic
    @Column(name = "busqueda", nullable = false, length = 300)
    private String busqueda;
    @Basic
    @Column(name = "analista_id", nullable = false)
    private Integer analistaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public Integer getAnalistaId() {
        return analistaId;
    }

    public void setAnalistaId(Integer analistaId) {
        this.analistaId = analistaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analisis analisis = (Analisis) o;
        return Objects.equals(id, analisis.id) && Objects.equals(nombre, analisis.nombre) && Objects.equals(descripcion, analisis.descripcion) && Objects.equals(busqueda, analisis.busqueda) && Objects.equals(analistaId, analisis.analistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, busqueda, analistaId);
    }
}
