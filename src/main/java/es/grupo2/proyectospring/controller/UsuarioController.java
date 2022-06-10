package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.entity.Usuario;
import es.grupo2.proyectospring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    UsuarioRepository usuarioRepository;

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    @Autowired
    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/")
    public String prueba(Model model){
        Usuario user = usuarioRepository.findById(4).orElse(null);

        model.addAttribute("user", user);

        return "prueba";
    }
}
