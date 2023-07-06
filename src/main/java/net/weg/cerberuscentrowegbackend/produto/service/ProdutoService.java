package net.weg.cerberuscentrowegbackend.produto.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;

    private EspecificacaoProdutoService especificacaoProdutoService;

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public ProdutoSemPerguntasProjection findOne(String nome) {
        return repository.findProdutoByNome(nome).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public Produto findByNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public List<ProdutoMinimizadoProjection> findAllMinimizado() {
        return repository.findAllBy();
    }

    public Boolean delete(Long id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    public Boolean addEspecificacao(String nome, Long idEspecificacao) {
        EspecificacaoProduto especificacao = especificacaoProdutoService.findOne(idEspecificacao);
        Produto produto = findByNome(nome);
        produto.getEspecificacoes().add(especificacao);
        return produto.getEspecificacoes().contains(especificacao);
    }

    public Page<ProdutoPerguntasProjection> findPerguntas(String nomeProduto, Pageable pageable) {
        return repository.findAllByNome(nomeProduto, pageable);
    }
}
