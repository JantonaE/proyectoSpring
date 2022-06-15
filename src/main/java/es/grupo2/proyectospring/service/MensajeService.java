package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.dto.MensajeDTO;
import es.grupo2.proyectospring.entity.Mensaje;
import es.grupo2.proyectospring.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    AUTHOR: Jesús Antona Espejo
*/
@Service
public class MensajeService {
    private MensajeRepository mensajeRepository;

    @Autowired
    public void setMensajeRepository(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public MensajeDTO buscarMensaje (long id) {
        Mensaje m = this.mensajeRepository.findById((int) id).orElse(null);;
        return m.toDTO();
    }

    public void borrarMensaje (long id) {
        Mensaje m = this.mensajeRepository.findById((int) id).orElse(null);;
        this.mensajeRepository.delete(m);
    }

    private void rellenarMensaje (Mensaje m,long destinatarioid,long emisorid,String asunto,String cuerpo,String leido) {
        m.setAsunto(asunto);
        m.setCuerpo(cuerpo);
        m.setDestinatarioId((int) destinatarioid);
        m.setEmisorId((int) emisorid);
        m.setId(m.getId());
        m.setLeido(leido);
    }

    public void crearMensaje (long destinatarioid,long emisorid,String asunto,String cuerpo,String leido) {
        Mensaje m = new Mensaje();

        this.rellenarMensaje(m,destinatarioid,emisorid,asunto,cuerpo,leido);

        this.mensajeRepository.save(m);
    }

    public void modificarMensaje(long id,long destinatarioid,long emisorid,String asunto,String cuerpo,String leido) {
        Mensaje m = this.mensajeRepository.findById((int) id).orElse(null);

        this.rellenarMensaje(m, destinatarioid, emisorid, asunto, cuerpo, leido);

        this.mensajeRepository.save(m);
    }

}
