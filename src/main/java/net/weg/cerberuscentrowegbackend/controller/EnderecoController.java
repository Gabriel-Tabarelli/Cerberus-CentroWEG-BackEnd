package net.weg.cerberuscentrowegbackend.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.EnderecoDto;
import net.weg.cerberuscentrowegbackend.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.service.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestBody @Valid EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
        return ResponseEntity.ok(enderecoService.create(endereco));
    }

    @PutMapping
    public ResponseEntity<Endereco> update(@RequestBody @Valid Endereco endereco) {
        return ResponseEntity.ok(enderecoService.update(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.ok(enderecoService.findAll());
    }
    
}
