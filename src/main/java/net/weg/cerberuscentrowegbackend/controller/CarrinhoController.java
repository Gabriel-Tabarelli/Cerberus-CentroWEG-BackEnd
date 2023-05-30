package net.weg.cerberuscentrowegbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.CarrinhoDto;
import net.weg.cerberuscentrowegbackend.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.service.CarrinhoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    @PostMapping
    public ResponseEntity<Carrinho> create(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        Carrinho carrinho = new Carrinho();
        BeanUtils.copyProperties(carrinhoDto, carrinho);
        return ResponseEntity.ok(carrinhoService.create(carrinho));
    }

    @PutMapping
    public ResponseEntity<Carrinho> update(@RequestBody @Valid Carrinho carrinho) {
        return ResponseEntity.ok(carrinhoService.update(carrinho));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<Carrinho>> findAll() {
        return ResponseEntity.ok(carrinhoService.findAll());
    }

}
