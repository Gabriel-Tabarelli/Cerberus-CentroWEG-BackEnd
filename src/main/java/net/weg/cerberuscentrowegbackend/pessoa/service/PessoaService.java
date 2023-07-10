package net.weg.cerberuscentrowegbackend.pessoa.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;

    public Pessoa getOne(Long id) {
        return repository.findById(id).orElseThrow(ObjetoInexistenteException::new);
    }

}
