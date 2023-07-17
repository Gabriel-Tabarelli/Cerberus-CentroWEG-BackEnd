package net.weg.cerberuscentrowegbackend.endereco.controller;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.endereco.model.dto.EnderecoDto;
import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.endereco.service.EnderecoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/endereco")
public class EnderecoController {

    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoDto, endereco);
        enderecoService.save(endereco);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid Endereco endereco) {
        enderecoService.update(endereco);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.findOne(id));
    }

}
