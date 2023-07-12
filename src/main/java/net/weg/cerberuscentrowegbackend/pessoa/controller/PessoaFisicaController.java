package net.weg.cerberuscentrowegbackend.pessoa.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.dto.PessoaFisicaDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaFisicaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/api/pessoa-fisica")
public class PessoaFisicaController {

    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<PessoaFisica> save(@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
        PessoaFisica pessoaFisica = new PessoaFisica();
        BeanUtils.copyProperties(pessoaFisicaDto, pessoaFisica);
        return ResponseEntity.ok(pessoaFisicaService.create(pessoaFisica));
    }

    @PutMapping
    public ResponseEntity<PessoaFisica> update(@RequestBody @Valid PessoaFisica pessoaFisica) {
        return ResponseEntity.ok(pessoaFisicaService.update(pessoaFisica));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Boolean> delete(@PathVariable String cpf) {
        return ResponseEntity.ok(pessoaFisicaService.delete(cpf));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<PessoaFisica> findOne(@PathVariable String cpf) {
        return ResponseEntity.ok(pessoaFisicaService.findOne(cpf));
    }

}
