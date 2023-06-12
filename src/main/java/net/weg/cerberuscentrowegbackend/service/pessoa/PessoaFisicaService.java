package net.weg.cerberuscentrowegbackend.service.pessoa;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.pessoa.PessoaFisica;
import net.weg.cerberuscentrowegbackend.repository.pessoa.PessoaFisicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<PessoaFisica> usuarioOptional = pessoaFisicaRepository.findById(cpf);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }
        throw new RuntimeException("Usuario não encontrado!");
    }

    public List<PessoaFisica> findAll() {
        return pessoaFisicaRepository.findAll();
    }

    public Boolean delete(String cpf) {
        pessoaFisicaRepository.deleteById(cpf);
        return !pessoaFisicaRepository.existsById(cpf);
    }

}
