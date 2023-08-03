package net.weg.cerberuscentrowegbackend.produto.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository repository;
    private PessoaService pessoaService;

    public void save(ProdutoDto produtoDto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(produtoDto, produto);
        produtoDto.getPerguntas().forEach(pergunta -> {
            if (pergunta.getListaRespostas() != null) {
                pergunta.getListaRespostas().forEach(resposta -> {
                    Pessoa pessoa = pessoaService.findOne(resposta.getPessoa().getId());
                    resposta.setPessoa(pessoa);
                });
            }
            Pessoa pessoa = pessoaService.findOne(pergunta.getPessoa().getId());
            pergunta.setPessoa(pessoa);
            pergunta.setProduto(produto);
        });
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

    public Page<ProdutoMinimizadoProjection> findAllMinimizado(Pageable pageable) {
        return repository.findAllBy(pageable);
    }

    public List<ProdutoMinimizadoProjection> findAllMinimizado(String categoriaId) {
        return repository.findAllByCategoria_Nome(categoriaId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<ProdutoPerguntasProjection> findPerguntas(Long id, Pageable pageable) {
        return repository.findAllById(id, pageable);
    }

    public List<ProdutoMinimizadoProjection> findAllByPesquisa(String pesquisa) {
        return repository.findAllByNomeContainingIgnoreCaseOrCategoria_NomeContainingIgnoreCase(pesquisa, pesquisa);
    }
}
