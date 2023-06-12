package net.weg.cerberuscentrowegbackend.service.pessoa;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.pessoa.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.repository.pessoa.PessoaJuridicaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public PessoaJuridica findOne(String cpf) {
        Optional<PessoaJuridica> usuarioOptional = pessoaJuridicaRepository.findById(cpf);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }
        throw new RuntimeException("Empresa não encontrada!");
    }

    public List<PessoaJuridica> findAll() {
        return pessoaJuridicaRepository.findAll();
    }

    public Boolean delete(String cnpj) {
        pessoaJuridicaRepository.deleteById(cnpj);
        return !pessoaJuridicaRepository.existsById(cnpj);
    }
    
}
