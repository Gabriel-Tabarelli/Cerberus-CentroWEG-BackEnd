package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
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

    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProdutoDto produtoDto) {
        service.save(produtoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoSemPerguntasProjection> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOneById(id));
    }

    @GetMapping("/get/minimizados")
    public ResponseEntity<List<ProdutoMinimizadoProjection>> findAllMinimizado() {
        System.out.println("Minimizadao");
        return ResponseEntity.ok(service.findAllMinimizado());

    }

    @GetMapping("/{id}/perguntas")
    public ResponseEntity<Page<ProdutoPerguntasProjection>> findPerguntas(
            @PathVariable Long id,
            @RequestParam("page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("nome").descending());
        return ResponseEntity.ok(service.findPerguntas(id, pageable));
    }

}
