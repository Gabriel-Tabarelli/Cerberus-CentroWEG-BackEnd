package net.weg.cerberuscentrowegbackend.produto.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.repository.ProdutoRepository;
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
                ObjetoInexistenteException::new);
    }

    public Produto findByNome(String nome) {
        return produtoRepository.findByNome(nome).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public List<ProdutoMinimizadoProjection> findAllMinimizado() {
        return produtoRepository.findAllBy();
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
