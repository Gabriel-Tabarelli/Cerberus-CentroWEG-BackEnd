package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/produto")
public class ProdutoController {

    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.ok(service.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/{nomeProduto}")
    public ResponseEntity<ProdutoSemPerguntasProjection> findOne(@PathVariable String nomeProduto) {
        return ResponseEntity.ok(service.findOne(nomeProduto));
    }

    @GetMapping("/get-minimizados")
    public ResponseEntity<List<ProdutoMinimizadoProjection>> findAllMinimizado() {
        return ResponseEntity.ok(service.findAllMinimizado());
    }

    @GetMapping("/{nomeProduto}/perguntas")
    public ResponseEntity<Page<ProdutoPerguntasProjection>> findPerguntas(
            @PathVariable String nomeProduto,
            @RequestParam("pageable") Pageable pageable
    ) {
        return ResponseEntity.ok(service.findPerguntas(nomeProduto, pageable));
    }

    @PutMapping("/{nomeProduto}/adicionar-especificacao/{idEspecificacao}")
    public ResponseEntity<Void> addEspecificacao(@PathVariable String nomeProduto,
                                                    @PathVariable Long idEspecificacao) {
        service.addEspecificacao(nomeProduto, idEspecificacao);
        return ResponseEntity.ok().build();
    }

}
