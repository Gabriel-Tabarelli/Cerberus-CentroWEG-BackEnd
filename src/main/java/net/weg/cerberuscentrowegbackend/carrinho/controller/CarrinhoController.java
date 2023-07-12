package net.weg.cerberuscentrowegbackend.carrinho.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.dto.CarrinhoDto;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.carrinho.service.CarrinhoService;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;
    private ProdutoService produtoService;

    @PostMapping
    public void save(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        Carrinho carrinho = new Carrinho();
        BeanUtils.copyProperties(carrinhoDto, carrinho);
        carrinhoService.save(carrinho);
    }

    @PutMapping
    public void update(@RequestBody @Valid Carrinho carrinho) {
        carrinhoService.update(carrinho);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carrinhoService.delete(id);
    }

    @GetMapping("/{id}")
    public Carrinho findOne(@PathVariable Long id) {
        return carrinhoService.findOne(id);
    }

    @PutMapping("/{idCarrinho}/adicionar-produto/{nomeProduto}")
    public void addProduto(@PathVariable Long idCarrinho,
                           @PathVariable Long nomeProduto) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        Produto produto = produtoService.findById(nomeProduto);
        carrinhoService.addProduto(carrinho, produto);
    }

    @PutMapping("/{idCarrinho}/remover-produto/{idProduto}")
    public void rmProduto(@PathVariable Long idCarrinho,
                          @PathVariable Long idProduto) {
        Carrinho carrinho = carrinhoService.findOne(idCarrinho);
        Produto produto = produtoService.findById(idProduto);
        carrinhoService.rmProduto(carrinho, produto);
    }

}
