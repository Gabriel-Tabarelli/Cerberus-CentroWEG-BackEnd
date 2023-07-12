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

    public void save(Produto produto) {
        repository.save(produto);
    }

    public ProdutoSemPerguntasProjection findOneById(Long id) {
        return repository.findProdutoById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public Produto findById(Long id) {
        return repository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public List<ProdutoMinimizadoProjection> findAllMinimizado() {
        return repository.findAllBy();
    }

    public List<ProdutoMinimizadoProjection> findAllMinimizado(Long categoriaId) {
        return repository.findAllByCategoria_Id(categoriaId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void addEspecificacao(Long id, Long idEspecificacao) {
        EspecificacaoProduto especificacao = especificacaoProdutoService.findOne(idEspecificacao);
        Produto produto = findById(id);
        produto.getEspecificacoes().add(especificacao);
    }

    public Page<ProdutoPerguntasProjection> findPerguntas(Long id, Pageable pageable) {
        return repository.findAllById(id, pageable);
    }
}
