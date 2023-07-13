package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.dto.EspecificacaoProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.produto.service.EspecificacaoProdutoService;
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
    public ResponseEntity<Void> create(@RequestBody @Valid EspecificacaoProdutoDto especificacaoProdutoDto) {
        EspecificacaoProduto especificacaoProduto = new EspecificacaoProduto();
        BeanUtils.copyProperties(especificacaoProdutoDto, especificacaoProduto);
        especificacaoProdutoService.save(especificacaoProduto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        especificacaoProdutoService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
