package net.weg.cerberuscentrowegbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.EspecificacaoProdutoDto;
import net.weg.cerberuscentrowegbackend.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.service.EspecificacaoProdutoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/especificacao-produto")
public class EspecificacaoProdutoController {

    private EspecificacaoProdutoService especificacaoProdutoService;

    @PostMapping
    public ResponseEntity<EspecificacaoProduto> create(@RequestBody @Valid EspecificacaoProdutoDto especificacaoProdutoDto) {
        EspecificacaoProduto especificacaoProduto = new EspecificacaoProduto();
        BeanUtils.copyProperties(especificacaoProdutoDto, especificacaoProduto);
        return ResponseEntity.ok(especificacaoProdutoService.create(especificacaoProduto));
    }

    @PutMapping
    public ResponseEntity<EspecificacaoProduto> update(@RequestBody @Valid EspecificacaoProduto especificacaoProduto) {
        return ResponseEntity.ok(especificacaoProdutoService.update(especificacaoProduto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(especificacaoProdutoService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspecificacaoProduto> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(especificacaoProdutoService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<EspecificacaoProduto>> findAll() {
        return ResponseEntity.ok(especificacaoProdutoService.findAll());
    }
    
}
