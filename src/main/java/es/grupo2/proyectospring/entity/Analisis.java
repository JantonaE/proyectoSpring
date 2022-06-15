package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.AnalisisDTO;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "analista_id", referencedColumnName = "usuario_id", nullable = false)
    private Analista analistaByAnalistaId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Analisis analisis = (Analisis) o;

        if (id != null ? !id.equals(analisis.id) : analisis.id != null) return false;
        if (nombre != null ? !nombre.equals(analisis.nombre) : analisis.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(analisis.descripcion) : analisis.descripcion != null)
            return false;
        if (busqueda != null ? !busqueda.equals(analisis.busqueda) : analisis.busqueda != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (busqueda != null ? busqueda.hashCode() : 0);
        return result;
    }

    public Analista getAnalistaByAnalistaId() {
        return analistaByAnalistaId;
    }

    public void setAnalistaByAnalistaId(Analista analistaByAnalistaId) {
        this.analistaByAnalistaId = analistaByAnalistaId;
    }

    public AnalisisDTO toDTO(){
        AnalisisDTO analisis = new AnalisisDTO(this.id.intValue(), this.nombre, this.busqueda);
        analisis.setDescripcion(this.descripcion);

        return analisis;
    }
}
