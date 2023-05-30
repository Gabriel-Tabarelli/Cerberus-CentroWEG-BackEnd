package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.repository.EspecificacaoProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EspecificacaoProdutoService {

    private EspecificacaoProdutoRepository especificacaoProdutoRepository;

    public EspecificacaoProduto create(EspecificacaoProduto especificacaoProduto) {
        return especificacaoProdutoRepository.save(especificacaoProduto);
    }

    public EspecificacaoProduto update(EspecificacaoProduto especificacaoProduto) {
        return especificacaoProdutoRepository.save(especificacaoProduto);
    }

    public EspecificacaoProduto findOne(Long id) {
        Optional<EspecificacaoProduto> especificacaoProdutoOptional = especificacaoProdutoRepository.findById(id);
        if (especificacaoProdutoOptional.isPresent()) {
            return especificacaoProdutoOptional.get();
        }
        throw new RuntimeException("EspecificacaoProduto não encontrado!");
    }

    public List<EspecificacaoProduto> findAll() {
        return especificacaoProdutoRepository.findAll();
    }

    public Boolean delete(Long id) {
        especificacaoProdutoRepository.deleteById(id);
        return !especificacaoProdutoRepository.existsById(id);
    }

}
