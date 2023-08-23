package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaProjection;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoSemPerguntasDto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/produto")
@CrossOrigin
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProdutoDto produtoDto) {
        service.save(produtoDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoSemPerguntasDto> findOne(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.findOneById(id));
    }

    @GetMapping("/{id}/perguntas")
    public ResponseEntity<Page<PerguntaProjection>> findPerguntas(
            @PathVariable Long id,
            @RequestParam("page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("id").descending());
        return ResponseEntity.ok(service.findPerguntas(id, pageable));
    }

    @GetMapping("/get/pesquisa/{pesquisa}")
    public ResponseEntity<List<ProdutoMinimizadoProjection>> findAllByPesquisa(
            @PathVariable String pesquisa
    ) {
        return ResponseEntity.ok(service.findAllByPesquisa(pesquisa));
    }

    @GetMapping("/get/minimizados/mais-vendidos")
    public ResponseEntity<Page<ProdutoMinimizadoProjection>> findAllMinimizadoMaisVendidos(
            @RequestParam("page") int page) {
        return ResponseEntity.ok(service.findAllMinimizadoMaisVendidos(PageRequest.of(page, 5)));
    }

    @GetMapping("/get/minimizados/mais-recentes")
    public ResponseEntity<Page<ProdutoMinimizadoProjection>> findAllMinimizadoRecentes(
            @RequestParam("page") int page) {
        return ResponseEntity.ok(service.findAllMinimizadoMaisRecentes(PageRequest.of(page, 5)));
    }

    @GetMapping("/get/minimizados/similares")
    public ResponseEntity<Page<ProdutoMinimizadoProjection>> findAllMinimizadoSimilar(
            @RequestParam("page") int page,
            @RequestParam("nome") String nome) {
        return ResponseEntity.ok(service.findAllMinimizadoSimilar(nome, PageRequest.of(page, 5)));
    }

    @GetMapping("/get/minimizados/destaques")
    public ResponseEntity<Page<ProdutoMinimizadoProjection>> findAllMinimizadoDestaques(
            @RequestParam("page") int page) {
        return ResponseEntity.ok(service.findAllMinimizadoDestaques(PageRequest.of(page, 5)));
    }

}
