package net.weg.cerberuscentrowegbackend.pessoa.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaJuridicaDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaJuridicaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pessoa-juridica")
public class PessoaJuridicaController {
    
    private PessoaJuridicaService pessoaJuridicaService;

    @PostMapping
    public ResponseEntity<PessoaJuridica> save(@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto) {
        PessoaJuridica pessoaJuridica = new PessoaJuridica();
        BeanUtils.copyProperties(pessoaJuridicaDto, pessoaJuridica);
        return ResponseEntity.ok(pessoaJuridicaService.create(pessoaJuridica));
    }

    @PutMapping
    public ResponseEntity<PessoaJuridica> update(@RequestBody @Valid PessoaJuridica pessoaJuridica) {
        return ResponseEntity.ok(pessoaJuridicaService.update(pessoaJuridica));
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Boolean> delete(@PathVariable String cnpj) {
        return ResponseEntity.ok(pessoaJuridicaService.delete(cnpj));
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<PessoaJuridica> findOne(@PathVariable String cnpj) {
        return ResponseEntity.ok(pessoaJuridicaService.findOne(cnpj));
    }

}
