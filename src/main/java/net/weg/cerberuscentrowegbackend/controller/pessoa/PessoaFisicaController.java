package net.weg.cerberuscentrowegbackend.controller.pessoa;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.pessoa.PessoaFisicaDto;
import net.weg.cerberuscentrowegbackend.model.entity.pessoa.PessoaFisica;
import net.weg.cerberuscentrowegbackend.service.pessoa.PessoaFisicaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<PessoaFisica> createPessoaFisica(@RequestBody @Valid PessoaFisicaDto pessoaFisicaDto) {
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

    @GetMapping()
    public ResponseEntity<List<PessoaFisica>> findAll() {
        return ResponseEntity.ok(pessoaFisicaService.findAll());
    }

}
