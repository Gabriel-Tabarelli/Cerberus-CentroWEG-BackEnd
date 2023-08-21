package net.weg.cerberuscentrowegbackend.carrinho.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.dto.CarrinhoDto;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.carrinho.service.CarrinhoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        Carrinho carrinho = new Carrinho();
        BeanUtils.copyProperties(carrinhoDto, carrinho);
        carrinhoService.save(carrinho);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Carrinho> findOne(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(carrinhoService.findOne(idPessoa));
    }

    @PutMapping
    public ResponseEntity<Void> addProduto(@RequestBody Carrinho carrinho) {
        carrinhoService.save(carrinho);
        return ResponseEntity.ok().build();
    }

}
