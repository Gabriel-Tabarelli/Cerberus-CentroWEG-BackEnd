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

@Controller
@AllArgsConstructor
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        Carrinho carrinho = new Carrinho();
        BeanUtils.copyProperties(carrinhoDto, carrinho);
        carrinhoService.save(carrinho);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid Carrinho carrinho) {
        carrinhoService.update(carrinho);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carrinhoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(carrinhoService.findOne(id));
    }

    @PutMapping("/{idCarrinho}/adicionar-produto/{nomeProduto}")
    public ResponseEntity<Void> addProduto(@PathVariable Long idCarrinho,
                                           @PathVariable Long nomeProduto) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        Produto produto = produtoService.findById(nomeProduto);
        carrinhoService.addProduto(carrinho, produto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idCarrinho}/remover-produto/{idProduto}")
    public ResponseEntity<Void> rmProduto(@PathVariable Long idCarrinho,
                                          @PathVariable Long idProduto) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        Produto produto = produtoService.findById(idProduto);
        carrinhoService.rmProduto(carrinho, produto);
        return ResponseEntity.ok().build();
    }

}
