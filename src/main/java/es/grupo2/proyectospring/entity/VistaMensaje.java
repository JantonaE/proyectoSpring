package es.grupo2.proyectospring.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "Vista_mensaje")
public class VistaMensaje {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "destinatario_id", nullable = false)
    private Integer destinatarioId;

    @Column(name = "emisor_id", nullable = false)
    private Integer emisorId;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "asunto", nullable = false, length = 50)
    private String asunto;

    @Column(name = "cuerpo", length = 250)
    private String cuerpo;

    @Column(name = "leido", nullable = false, length = 1)
    private String leido;

    public Integer getId() {
        return id;
    }

    public Integer getDestinatarioId() {
        return destinatarioId;
    }

    public Integer getEmisorId() {
        return emisorId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public String getLeido() {
        return leido;
    }

    protected VistaMensaje() {
    }
}