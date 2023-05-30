package net.weg.cerberuscentrowegbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.ok(produtoService.create(produto));
    }

    @PutMapping
    public ResponseEntity<Produto> update(@RequestBody @Valid Produto produto) {
        return ResponseEntity.ok(produtoService.update(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PutMapping("/{idProduto}/adicionar-especificacao/{idEspecificacao}")
    public ResponseEntity<Boolean> addEspecificacao(@PathVariable Long idProduto, @PathVariable Long idEspecificacao) {
        return ResponseEntity.ok(produtoService.addEspecificacao(idProduto, idEspecificacao));
    }
}
