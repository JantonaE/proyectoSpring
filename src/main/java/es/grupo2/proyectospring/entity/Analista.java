package es.grupo2.proyectospring.entity;

import es.grupo2.proyectospring.dto.AnalisisDTO;
import es.grupo2.proyectospring.dto.AnalistaDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Analista {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;
    @OneToMany(mappedBy = "analistaByAnalistaId")
    private List<Analisis> analisesByUsuarioId;

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

        Analista analista = (Analista) o;

        if (usuarioId != null ? !usuarioId.equals(analista.usuarioId) : analista.usuarioId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return usuarioId != null ? usuarioId.hashCode() : 0;
    }

    public List<Analisis> getAnalisesByUsuarioId() {
        return analisesByUsuarioId;
    }

    public void setAnalisesByUsuarioId(List<Analisis> analisesByUsuarioId) {
        this.analisesByUsuarioId = analisesByUsuarioId;
    }

    public AnalistaDTO toDTO(){
        AnalistaDTO an = new AnalistaDTO();
        an.setUsuarioId(usuarioId);

        List<AnalisisDTO> analisis = new ArrayList<AnalisisDTO>();
        for(Analisis a : this.getAnalisesByUsuarioId()){
            analisis.add(a.toDTO());
        }
        an.setAnalisisList(analisis);

        return an;
    }
}
