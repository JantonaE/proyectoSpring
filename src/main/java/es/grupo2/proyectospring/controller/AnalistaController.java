package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.dto.AnalisisDTO;
import es.grupo2.proyectospring.dto.AnalistaDTO;
import es.grupo2.proyectospring.entity.Analista;
import es.grupo2.proyectospring.repository.AnalisisRepository;
import es.grupo2.proyectospring.repository.AnalistaRepository;
import es.grupo2.proyectospring.service.AnalisisService;
import es.grupo2.proyectospring.service.AnalistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnalistaController {

    private AnalistaService analistaService;

    private AnalisisService analisisService;

    public AnalistaService getAnalistaService() {
        return analistaService;
    }

    @Autowired
    public void setAnalistaService(AnalistaService analistaService) {
        this.analistaService = analistaService;
    }

    public AnalisisService getAnalisisService() {
        return analisisService;
    }

    @Autowired
    public void setAnalisisService(AnalisisService analisisService) {
        this.analisisService = analisisService;
    }


    @GetMapping("/analista/{id}")
    private String verlistaAnalisis(@PathVariable("id") String id, Model model){
        Analista analista = analistaService.findById(id);
        AnalistaDTO analistaDTO = new AnalistaDTO();
        analistaDTO.setAnalisisList(new ArrayList<AnalisisDTO>());
        if(analista!=null){
            analistaDTO = analista.toDTO();
        }

        model.addAttribute("analisis", analistaDTO.getAnalisisList());
        model.addAttribute("analista", analistaDTO);

        return "VistaAnalisis";
    }

    @GetMapping("/analista/{id_analista}/ver/{id_analisis}")
    private String verAnalisis(@PathVariable("id_analisis") Integer id_analisis, @PathVariable("id_analista") Integer id_analista, Model model){


        return "AnalisisUsuarios";
    }

    @GetMapping("/analista/{id_analista}/copiar/{id_analisis}")
    private String copiarAnalisis(@PathVariable("id_analisis") String id_analisis, @PathVariable("id_analista") Integer id_analista, Model model){
        analisisService.copiarAnalisis(id_analisis);

        return "redirect:/analista/"+id_analista;
    }

    @GetMapping("/analista/{id_analista}/borrar/{id_analisis}")
    private String borrarAnalisis(@PathVariable("id_analisis") String id_analisis, @PathVariable("id_analista") Integer id_analista, Model model){
        analisisService.borrarAnalisis(id_analisis);

        return "redirect:/analista/"+id_analista;
    }

}
