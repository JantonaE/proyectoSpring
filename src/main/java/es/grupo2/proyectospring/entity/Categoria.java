package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.CategoriaDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Categoria {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id) && Objects.equals(titulo, categoria.titulo) && Objects.equals(descripcion, categoria.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, descripcion);
    }

    public CategoriaDTO toDTO(){
        CategoriaDTO ca = new CategoriaDTO(id, titulo, descripcion);
        return ca;
    }

}
