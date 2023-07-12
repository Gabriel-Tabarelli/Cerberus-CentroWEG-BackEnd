package net.weg.cerberuscentrowegbackend.pessoa.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaEditarDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaFisicaDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaJuridicaDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/api/pessoa")
public class PessoaController {

    private PessoaService service;

    @PostMapping("/pessoa-juridica")
    public void save(@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridica);
        service.save(pessoaJuridica);
    }

    @PostMapping("/pessoa-fisica")
    public void save(@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisica);
        service.save(pessoaFisica);
    }

    @PutMapping("/editar/{id}")
    public void update(@RequestBody @Valid PessoaEditarDto pessoaDto, @PathVariable Long id) {
        Pessoa pessoa = service.findOne(id);
        pessoa.editar(pessoaDto);
        service.update(pessoa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Object findOne(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PutMapping("/{id}/adicionar-favorito/{idProduto}")
    public void adicionarFavorito(@PathVariable Long id, @PathVariable Long idProduto) {
        service.adicionarFavorito(id, idProduto);
    }

    @PutMapping("/{id}/remover-favorito/{idProduto}")
    public void removerFavorito(@PathVariable Long id, @PathVariable Long idProduto) {
        service.removerFavorito(id, idProduto);
    }

}
