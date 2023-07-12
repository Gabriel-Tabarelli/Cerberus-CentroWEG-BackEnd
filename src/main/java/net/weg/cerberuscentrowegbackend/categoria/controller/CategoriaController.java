package net.weg.cerberuscentrowegbackend.categoria.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.categoria.model.dto.CategoriaDto;
import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.categoria.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    private CategoriaService service;

    @PostMapping
    public void save(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);
        service.save(categoria);
    }

    @GetMapping("/{id}")
    public List<?> findCategorias(@PathVariable Long id) {
        return service.findCategorias(id);
    }

    @GetMapping()
    public List<Categoria> findAll() {
        return service.findAll();
    }

}
