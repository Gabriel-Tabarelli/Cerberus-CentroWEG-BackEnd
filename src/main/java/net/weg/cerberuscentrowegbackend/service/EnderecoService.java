package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco update(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Endereco findOne(Long id) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(id);
        if (enderecoOptional.isPresent()) {
            return enderecoOptional.get();
        }
        throw new RuntimeException("Endereco não encontrado!");
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Boolean delete(Long id) {
        enderecoRepository.deleteById(id);
        return !enderecoRepository.existsById(id);
    }
    
}
