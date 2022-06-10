package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.entity.Mensaje;
import es.grupo2.proyectospring.entity.VistaMensaje;
import es.grupo2.proyectospring.repository.MensajeRepository;
import es.grupo2.proyectospring.repository.VistaMensajeRepository;
import es.grupo2.proyectospring.service.ListaService;
import es.grupo2.proyectospring.service.MensajeService;
import es.grupo2.proyectospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControllerMensajes {
    private UsuarioService usuarioService;
    private VistaMensajeRepository vistaMensajeRepository;
    private MensajeRepository mensajeRepository;
    private ListaService listaService;
    private MensajeService mensajeService;
/*
    @Autowired
    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
    }
*/
    @Autowired
    public void setListaService(ListaService listaService) {
        this.listaService = listaService;
    }

    @Autowired
    public void setMensajeRepository(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }


    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @Autowired
    public void setVistaMensajeRepository(VistaMensajeRepository vistaMensajeRepository) {
        this.vistaMensajeRepository = vistaMensajeRepository;
    }

    @RequestMapping ("/bandeja/{id}")
    public String showBandeja(@PathVariable("id") int idUsuario, Model model){
        //List<Mensaje> vistaMensajeList = this.mensajeService.
        List<Mensaje> vistaMensajeList = this.mensajeRepository.findByUsuarioId(idUsuario);
        model.addAttribute("mensajes",vistaMensajeList);
        return "BandejaMensajes";
    }

    @RequestMapping("/marketing/mensaje/{id}")
    public String initCreadorMensaje(Model model, @PathVariable("id") int idLista){
        ListaDTO lista = this.listaService.buscarLista(idLista);
        model.addAttribute("lista",lista);

        return "redirect:/CreadorMensajes/";

    }

    @PostMapping("/marketing/enviar")
    public String enviarMensaje(Model model, @RequestParam("listaId") int idLista,
                                @RequestParam("titulo") String titulo,@RequestParam("contenido") String contenido){
        ListaDTO lista = this.listaService.buscarLista(idLista);
        //this.mensajeService.

        return "redirect:/CreadorMensajes/";

    }

}
