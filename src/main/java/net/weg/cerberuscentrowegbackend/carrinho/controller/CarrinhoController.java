package net.weg.cerberuscentrowegbackend.carrinho.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.dto.CarrinhoDto;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.carrinho.model.projectin.CarrinhoIdProdutosProjection;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.carrinho.service.CarrinhoService;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
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
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CarrinhoDto carrinhoDto) {
        Carrinho carrinho = new Carrinho();
        BeanUtils.copyProperties(carrinhoDto, carrinho);
        carrinhoService.save(carrinho);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<CarrinhoIdProdutosProjection> findOne(@PathVariable Long idPessoa) {
        return ResponseEntity.ok(carrinhoService.findOneProjection(idPessoa));
    }

    @PutMapping("/{idPessoa}/adicionar-remover-produto/{idProduto}")
    public ResponseEntity<Void> addProduto(@PathVariable Long idPessoa,
                                           @PathVariable Long idProduto) {
        Carrinho carrinho = carrinhoService.findOne(idPessoa);
        Produto produto = produtoService.findById(idProduto);
        carrinhoService.addRmProduto(carrinho, produto);
        return ResponseEntity.ok().build();
    }

}
