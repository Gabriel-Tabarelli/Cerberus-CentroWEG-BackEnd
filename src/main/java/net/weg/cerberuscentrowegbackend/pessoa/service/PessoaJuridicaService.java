package net.weg.cerberuscentrowegbackend.pessoa.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaJuridicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaJuridicaService {

    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public PessoaJuridica create(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaJuridica update(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public PessoaJuridica findOne(String cnpj) {
        return pessoaJuridicaRepository.findByCnpj(cnpj).orElseThrow(ObjetoInexistenteException::new);
    }

    public List<PessoaJuridica> findAll() {
        return pessoaJuridicaRepository.findAll();
    }

    public Boolean delete(String cnpj) {
        pessoaJuridicaRepository.deleteByCnpj(cnpj);
        return !pessoaJuridicaRepository.existsByCnpj(cnpj);
    }
    
}
