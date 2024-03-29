package net.weg.cerberuscentrowegbackend.pessoa.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaFisicaDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaJuridicaDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNotificacoesProjection;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaEnderecoProjection;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/pessoa")
public class PessoaController {

    private final PessoaService service;

    @PostMapping("/pessoa-juridica")
    public ResponseEntity<Void> save(@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridica);
        service.save(pessoaJuridica);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/pessoa-fisica")
    public ResponseEntity<Void> save(@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisica);
        service.save(pessoaFisica);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> update(@RequestBody @Valid Pessoa pessoa) {
        service.update(pessoa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Pessoa> findOne(
            @RequestParam("email") String email,
            @RequestParam("senha") String senha) {
        return ResponseEntity.ok(service.findOneByEmailAndSenha(email, senha));
    }

    @GetMapping("/{id}/notificacoes")
    public ResponseEntity<Page<NotificacaoProjection>> buscarNotificacoesNaoVisualizadas(
            @PathVariable Long id,
            @RequestParam("page") int page) {
        return ResponseEntity.ok(service.buscarNotificacoes(id, PageRequest.of(page, 5)));
    }

    @GetMapping("/{id}/notificacoes/existe-nao-visualizada")
    public ResponseEntity<Integer> haNotificacoesNaoVisualizadas(@PathVariable Long id) {
        return ResponseEntity.ok(service.haNotificacoesNaoVisualizadas(id));
    }

    @GetMapping("endereco/{id}")
    public ResponseEntity<PessoaEnderecoProjection> buscarEndereco(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarEndereco(id));
    }

    @PutMapping("/visualizar-comentario")
    public ResponseEntity<Void> visualizarComentario(@RequestBody Long idNotificacao) {
        service.visualizarComentario(idNotificacao);
        return ResponseEntity.ok().build();
    }

}
