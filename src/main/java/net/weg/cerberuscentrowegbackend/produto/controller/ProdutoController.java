package net.weg.cerberuscentrowegbackend.produto.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import org.springframework.beans.BeanUtils;
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
public class ProdutoController {

    private ProdutoService service;
    private PessoaService pessoaService;

    @PostMapping
    public void create(@RequestBody @Valid ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        for (Pergunta pergunta : produtoDto.getPerguntas()) {
            for (Resposta resposta : pergunta.getListaRespostas()) {
                Pessoa pessoa = pessoaService.findOne(resposta.getPessoa().getId());
                resposta.setPessoa(pessoa);
            }
            Pessoa pessoa = pessoaService.findOne(pergunta.getPessoa().getId());
            pergunta.setPessoa(pessoa);
            pergunta.setProduto(produto);
        }
        service.save(produto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public ProdutoSemPerguntasProjection findOne(@PathVariable Long id) {
        return service.findOneById(id);
    }

    @GetMapping("/get-minimizados")
    public List<ProdutoMinimizadoProjection> findAllMinimizado() {
        return service.findAllMinimizado();
    }

    @GetMapping("/{id}/perguntas")
    public Page<ProdutoPerguntasProjection> findPerguntas(
            @PathVariable Long id,
            @RequestParam("page") int page
    ) {
        Pageable pageable = PageRequest.of(page, 3, Sort.by("nome").descending());
        return service.findPerguntas(id, pageable);
    }

    @PutMapping("/{id}/adicionar-especificacao/{idEspecificacao}")
    public void addEspecificacao(@PathVariable Long id,
                                                    @PathVariable Long idEspecificacao) {
        service.addEspecificacao(id, idEspecificacao);
    }

}
