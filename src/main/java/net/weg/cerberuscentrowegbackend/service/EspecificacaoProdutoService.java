package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoNaoEncontradoException;
import net.weg.cerberuscentrowegbackend.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.repository.EspecificacaoProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EspecificacaoProdutoService {

    private EspecificacaoProdutoRepository especificacaoProdutoRepository;

    public EspecificacaoProduto save(EspecificacaoProduto especificacaoProduto) {
        return especificacaoProdutoRepository.save(especificacaoProduto);
    }

    public EspecificacaoProduto update(EspecificacaoProduto especificacaoProduto) {
        return especificacaoProdutoRepository.save(especificacaoProduto);
    }

    public EspecificacaoProduto findOne(Long id) {
        return especificacaoProdutoRepository.findById(id).orElseThrow(
                ObjetoNaoEncontradoException::new);
    }

    public List<EspecificacaoProduto> findAll() {
        return especificacaoProdutoRepository.findAll();
    }

    public Boolean delete(Long id) {
        especificacaoProdutoRepository.deleteById(id);
        return !especificacaoProdutoRepository.existsById(id);
    }

}
