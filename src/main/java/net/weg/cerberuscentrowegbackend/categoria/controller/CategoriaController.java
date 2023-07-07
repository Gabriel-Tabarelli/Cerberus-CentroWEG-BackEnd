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
@RequestMapping("/categoria")
public class CategoriaController {
    
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Categoria> save(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);
        return ResponseEntity.ok(service.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok(service.update(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }
    //commit
    @GetMapping()
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
