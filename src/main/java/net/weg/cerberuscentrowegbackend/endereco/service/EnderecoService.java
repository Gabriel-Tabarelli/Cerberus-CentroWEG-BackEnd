package net.weg.cerberuscentrowegbackend.endereco.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.endereco.projection.EnderecoProjection;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.endereco.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository enderecoRepository;

    public void save(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public void update(Endereco endereco) {
        enderecoRepository.save(endereco);
    }

    public Endereco findOne(Long id) {
        return enderecoRepository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }


//    public EnderecoProjection buscaEndereco(Long id) {
//        return enderecoRepository.findByPessoa_Id(id);
//    }
}
