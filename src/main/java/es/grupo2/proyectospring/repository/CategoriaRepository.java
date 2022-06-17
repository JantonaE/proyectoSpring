package es.grupo2.proyectospring.repository;


import es.grupo2.proyectospring.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer>{
    public List<Categoria> findByTitulo(String titulo);
}
