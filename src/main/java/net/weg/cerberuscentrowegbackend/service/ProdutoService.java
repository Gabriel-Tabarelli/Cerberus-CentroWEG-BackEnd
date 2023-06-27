package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoNaoEncontradoException;
import net.weg.cerberuscentrowegbackend.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private EspecificacaoProdutoService especificacaoProdutoService;

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto findOne(Long id) {
        return produtoRepository.findById(id).orElseThrow(
                ObjetoNaoEncontradoException::new);
    }

    public Produto findByNome(String nome) {
        return produtoRepository.findByNome(nome).orElseThrow(
                ObjetoNaoEncontradoException::new);
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Boolean delete(Long id) {
        produtoRepository.deleteById(id);
        return !produtoRepository.existsById(id);
    }

    public Boolean addEspecificacao(Long idProduto, Long idEspecificacao) {
        EspecificacaoProduto especificacao = especificacaoProdutoService.findOne(idEspecificacao);
        Produto produto = findOne(idProduto);
        produto.getEspecificacoes().add(especificacao);
        return produto.getEspecificacoes().contains(especificacao);
    }

}
