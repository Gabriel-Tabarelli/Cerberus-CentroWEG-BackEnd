package net.weg.cerberuscentrowegbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.CategoriaDto;
import net.weg.cerberuscentrowegbackend.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {
    
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody @Valid CategoriaDto categoriaDto) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoria);
        return ResponseEntity.ok(categoriaService.create(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> update(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok(categoriaService.update(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<Categoria>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

}
