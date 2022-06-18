package es.grupo2.proyectospring.controller;

import es.grupo2.proyectospring.dto.AnalisisDTO;
import es.grupo2.proyectospring.dto.AnalistaDTO;
import es.grupo2.proyectospring.dto.BusquedaDTO;
import es.grupo2.proyectospring.dto.UsuarioDTO;
import es.grupo2.proyectospring.entity.Analista;
import es.grupo2.proyectospring.service.AnalisisService;
import es.grupo2.proyectospring.service.AnalistaService;
import es.grupo2.proyectospring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

//Antonio Sepúlveda Zorrilla

@Controller
public class AnalistaController {

    private AnalistaService analistaService;

    private AnalisisService analisisService;

    private UsuarioService usuarioService;

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

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    @Autowired
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
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

    @GetMapping("/analista/ver/{id_analisis}")
    private String verAnalisis(@PathVariable("id_analisis") Integer id_analisis, Model model){
        BusquedaDTO busqueda = new BusquedaDTO();
        analisisService.analisisToBusquedaDTO(id_analisis, busqueda);
        List<UsuarioDTO> usuarios = usuarioService.findByFiltros(busqueda);

        model.addAttribute("busqueda", busqueda);
        model.addAttribute("usuarios", usuarios);

        List<Double> ingresos = new ArrayList<Double>();
        List<Integer> ventas = new ArrayList<Integer>();

        for(UsuarioDTO u : usuarios){
            ingresos.add(usuarioService.ingresosGenerados(u.getId().intValue()));
            ventas.add(usuarioService.numeroVentas(u.getId().intValue()));
        }

        model.addAttribute("ingresos", ingresos);
        model.addAttribute("ventas", ventas);

        return "AnalisisUsuarios";
    }

    @PostMapping("/analisis/filtrar")
    private String filtrarAnalisis(@ModelAttribute("busqueda") BusquedaDTO busqueda, Model model){
        model.addAttribute("busqueda", busqueda);

        List<UsuarioDTO> usuarios = usuarioService.findByFiltros(busqueda);

        model.addAttribute("usuarios", usuarios);

        List<Double> ingresos = new ArrayList<Double>();
        List<Integer> ventas = new ArrayList<Integer>();

        for(UsuarioDTO u : usuarios){
            ingresos.add(usuarioService.ingresosGenerados(u.getId().intValue()));
            ventas.add(usuarioService.numeroVentas(u.getId().intValue()));
        }

        model.addAttribute("ingresos", ingresos);
        model.addAttribute("ventas", ventas);

        return "AnalisisUsuarios";
    }

    @PostMapping("/analisis/guardar")
    private String guardarAnalisis(@ModelAttribute("busqueda") BusquedaDTO busqueda, Model model){
        model.addAttribute("busqueda", busqueda);

        analisisService.crearAnalisis(busqueda.getNombreBusqueda(), busqueda.getIdAnalista(), busqueda.getNombre(), busqueda.getApellidos(), busqueda.getDomicilio(),
                busqueda.getCiudad(), busqueda.getEdad(), busqueda.getSexo(), busqueda.getOrden());

        return "redirect:/analista/"+busqueda.getIdAnalista();
    }

    @PostMapping("/analisis/actualizar")
    private String actualizarAnalisis(@ModelAttribute("busqueda") BusquedaDTO busqueda, Model model){
        model.addAttribute("busqueda", busqueda);

        analisisService.actualizarAnalisis(busqueda.getIdAnalisis(), busqueda.getIdAnalista(), busqueda.getNombreBusqueda(), busqueda.getNombre(), busqueda.getApellidos(), busqueda.getDomicilio(),
                busqueda.getCiudad(), busqueda.getEdad(), busqueda.getSexo(), busqueda.getOrden());

        return "redirect:/analista/"+busqueda.getIdAnalista();
    }

    @GetMapping("/analista/{id_analista}/nuevo")
    private String nuevoAnalisis(@PathVariable("id_analista") Integer id_analista, Model model){
        BusquedaDTO busqueda = new BusquedaDTO(id_analista.toString());
        model.addAttribute("busqueda", busqueda);

        List<UsuarioDTO> usuarios = usuarioService.listarListas();

        model.addAttribute("usuarios", usuarios);

        List<Double> ingresos = new ArrayList<Double>();
        List<Integer> ventas = new ArrayList<Integer>();

        for(UsuarioDTO u : usuarios){
            ingresos.add(usuarioService.ingresosGenerados(u.getId().intValue()));
            ventas.add(usuarioService.numeroVentas(u.getId().intValue()));
        }

        model.addAttribute("ingresos", ingresos);
        model.addAttribute("ventas", ventas);

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
