package net.weg.cerberuscentrowegbackend.pessoa.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaFisicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaFisicaService {

    private PessoaFisicaRepository pessoaFisicaRepository;

    public PessoaFisica create(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaFisica update(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }

    public PessoaFisica findOne(String cpf) {
        return pessoaFisicaRepository.findByCpf(cpf).orElseThrow(ObjetoInexistenteException::new);
    }

    public List<PessoaFisica> findAll() {
        return pessoaFisicaRepository.findAll();
    }

    public Boolean delete(String cpf) {
        pessoaFisicaRepository.deleteByCpf(cpf);
        return !pessoaFisicaRepository.existsByCpf(cpf);
    }

}
