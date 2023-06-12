package net.weg.cerberuscentrowegbackend.controller.pessoa;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.pessoa.PessoaJuridicaDto;
import net.weg.cerberuscentrowegbackend.model.entity.pessoa.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.service.pessoa.PessoaJuridicaService;
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
    public ResponseEntity<PessoaJuridica> createPessoaJuridica(@RequestBody @Valid PessoaJuridicaDto pessoaJuridicaDto) {
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

    @GetMapping()
    public ResponseEntity<List<PessoaJuridica>> findAll() {
        return ResponseEntity.ok(pessoaJuridicaService.findAll());
    }

}
