package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.dto.ListaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.ListaUsuarios;
import es.grupo2.proyectospring.entity.Mensaje;
import es.grupo2.proyectospring.entity.Usuario;
import es.grupo2.proyectospring.entity.VistaMensaje;
import es.grupo2.proyectospring.repository.ListaUsuariosRepository;
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
/*
    AUTHOR: Jesús Antona Espejo
*/
@Controller
public class ControllerMensajes {
    private UsuarioService usuarioService;
    //private VistaMensajeRepository vistaMensajeRepository;
    private MensajeRepository mensajeRepository;
    private ListaUsuariosRepository listaUsuariosRepository;
    private ListaService listaService;
    private MensajeService mensajeService;

    @Autowired
    public void setListaUsuariosRepository(ListaUsuariosRepository listaUsuariosRepository) {
        this.listaUsuariosRepository = listaUsuariosRepository;
    }

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
    public void setMensajeService(MensajeService mensajeService) {
        this.mensajeService = mensajeService;
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
        System.out.println("El id llega:"+idLista);
        ListaDTO lista = this.listaService.buscarLista(idLista);
        System.out.println("El lista:"+lista.getDescripcion());
        model.addAttribute("lista",lista);

        return "CreadorMensajes";

    }

    @PostMapping("/marketing/enviar")
    public String enviarMensaje(Model model, @RequestParam("listaId") int idLista,@RequestParam("emisor") int idEmisor,
                                @RequestParam("titulo") String titulo,@RequestParam("contenido") String contenido){
        //ListaDTO lista = this.listaService.buscarLista(idLista);
        List<ListaUsuarios> lu = this.listaUsuariosRepository.findListaUsuariosByIDlista(idLista);
        //List<UsuarioDTO> lu= lista.getUsuarioList();
        for(ListaUsuarios u : lu){
            this.mensajeService.crearMensaje(u.getUsuarioId(),idEmisor,titulo,contenido,"0");
        }

        return "redirect:/marketing";

    }

}
