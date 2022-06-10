package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.MensajeDTO;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Mensaje {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "destinatario_id", nullable = false)
    private Integer destinatarioId;
    @Basic
    @Column(name = "emisor_id", nullable = false)
    private Integer emisorId;
    @Basic
    @Column(name = "asunto", nullable = false, length = 50)
    private String asunto;
    @Basic
    @Column(name = "cuerpo", nullable = true, length = 250)
    private String cuerpo;
    @Basic
    @Column(name = "leido", nullable = false, length = 1)
    private String leido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDestinatarioId() {
        return destinatarioId;
    }

    public void setDestinatarioId(Integer destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public Integer getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(Integer emisorId) {
        this.emisorId = emisorId;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getLeido() {
        return leido;
    }

    public void setLeido(String leido) {
        this.leido = leido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensaje mensaje = (Mensaje) o;
        return Objects.equals(id, mensaje.id) && Objects.equals(destinatarioId, mensaje.destinatarioId) && Objects.equals(emisorId, mensaje.emisorId) && Objects.equals(asunto, mensaje.asunto) && Objects.equals(cuerpo, mensaje.cuerpo) && Objects.equals(leido, mensaje.leido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destinatarioId, emisorId, asunto, cuerpo, leido);
    }

    public MensajeDTO toDTO() {
        MensajeDTO dto = new MensajeDTO();
        dto.setAsunto(asunto);
        dto.setCuerpo(cuerpo);
        dto.setDestinatarioId(destinatarioId);
        dto.setEmisorId(emisorId);
        dto.setLeido(leido);
        dto.setId(Long.valueOf(id));
        return dto;
    }
}
