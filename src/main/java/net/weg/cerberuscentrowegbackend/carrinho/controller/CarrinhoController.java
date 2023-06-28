package net.weg.cerberuscentrowegbackend.carrinho.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.dto.CarrinhoDto;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.carrinho.service.CarrinhoService;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
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
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Carrinho> save(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        Carrinho carrinho = new Carrinho();
        BeanUtils.copyProperties(carrinhoDto, carrinho);
        return ResponseEntity.ok(carrinhoService.save(carrinho));
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

    @PutMapping("/{idCarrinho}/adicionar-produto/{idProduto}")
    public ResponseEntity<Carrinho> addProduto(@PathVariable Long idCarrinho,
                                               @PathVariable Long idProduto) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        Produto produto = produtoService.findOne(idProduto);
        return ResponseEntity.ok(carrinhoService.addProduto(carrinho, produto));
    }

    @PutMapping("/{idCarrinho}/remover-produto/{idProduto}")
    public ResponseEntity<Carrinho> rmProduto(@PathVariable Long idCarrinho,
                                              @PathVariable Long idProduto) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        Produto produto = produtoService.findOne(idProduto);
        return ResponseEntity.ok(carrinhoService.rmProduto(carrinho, produto));
    }

}
