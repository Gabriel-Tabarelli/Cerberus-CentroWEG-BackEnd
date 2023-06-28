package net.weg.cerberuscentrowegbackend.endereco.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.endereco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco update(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco findOne(Long id) {
        return enderecoRepository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Boolean delete(Long id) {
        enderecoRepository.deleteById(id);
        return !enderecoRepository.existsById(id);
    }
    
}
