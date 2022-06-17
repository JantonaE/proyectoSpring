package es.grupo2.proyectospring.service;

import es.grupo2.proyectospring.repository.CategoriaRepository;
import es.grupo2.proyectospring.dto.CategoriaDTO;
import es.grupo2.proyectospring.entity.Categoria;
import es.grupo2.proyectospring.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    @Autowired
    public void setCategoriaRepository(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    protected List<CategoriaDTO> convertirAListaDTO (List<Categoria> lista){
        if (lista != null) {
            List<CategoriaDTO> listaDTO = new ArrayList<CategoriaDTO>();
            for (Categoria ca:lista) {
                listaDTO.add(ca.toDTO());
            }
            return listaDTO;
        } else {
            return null;
        }
    }

    public List<CategoriaDTO> listarCategorias (String filtroNombre) {
        List<Categoria> lista;

        if ((filtroNombre != null && filtroNombre.length()>0 )) {
            lista = this.categoriaRepository.findByTitulo(filtroNombre);
        } else {  // Quiero mostrar todos
            lista = this.categoriaRepository.findAll();
        }
        return this.convertirAListaDTO(lista);
    }

    public List<CategoriaDTO> listarCategorias () {
        return this.listarCategorias(null);
    }

    public void borrarCategoria (int id) {
        Categoria ca = this.categoriaRepository.findById(id).orElse(null);
        this.categoriaRepository.delete(ca);
    }

    public CategoriaDTO buscarCategoria (int id) {
        Categoria ca = this.categoriaRepository.findById(id).orElse(null);
        if (ca != null) {
            return ca.toDTO();
        } else {
            return null;
        }
    }

    public void guardarCategoria(CategoriaDTO dto){
        Categoria ca = new Categoria();
        ca.setId(dto.getId());
        ca.setDescripcion(dto.getDescripcion());
        ca.setTitulo(dto.getTitulo());
        this.categoriaRepository.save(ca);
    }
}
