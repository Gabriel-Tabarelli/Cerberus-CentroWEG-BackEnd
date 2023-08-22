package net.weg.cerberuscentrowegbackend.produto.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaProjection;
import net.weg.cerberuscentrowegbackend.pergunta.repository.PerguntaRepository;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.service.PessoaService;
import net.weg.cerberuscentrowegbackend.produto.model.dto.ProdutoDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final PessoaService pessoaService;
    private final PerguntaRepository perguntaRepository;

    public void save(ProdutoDto produtoDto) {
        Produto produto = new Produto();
        produto.setQtdVendas(0);
        BeanUtils.copyProperties(produtoDto, produto);
        produtoDto.getPerguntas().forEach(pergunta -> {
            if (pergunta.getListaRespostas() != null) {
                pergunta.getListaRespostas().forEach(resposta -> {
                    Pessoa pessoa = pessoaService.findOne(resposta.getRespondedor().getId());
                    resposta.setRespondedor(pessoa);
                });
            }
            Pessoa pessoa = pessoaService.findOne(pergunta.getPerguntador().getId());
            pergunta.setPerguntador(pessoa);
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

    public List<ProdutoMinimizadoProjection> findAllMinimizado(String categoriaId) {
        return repository.findAllByCategoria_Nome(categoriaId);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<PerguntaProjection> findPerguntas(Long id, Pageable pageable) {
        return perguntaRepository.findAllByProduto_Id(id, pageable);
    }

    public List<ProdutoMinimizadoProjection> findAllByPesquisa(String pesquisa) {
        return repository.findAllByNomeContainingIgnoreCaseOrCategoria_NomeContainingIgnoreCase(pesquisa, pesquisa);
    }

    public Page<ProdutoMinimizadoProjection> findAllMinimizadoMaisVendidos(Pageable pageable) {
        return repository.findAllMinimizadoMaisVendidos(pageable);
    }

    public Page<ProdutoMinimizadoProjection> findAllMinimizadoMaisRecentes(Pageable pageable) {
        return repository.findAllMinimizadoMaisRecentes(pageable);
    }

    public Page<ProdutoMinimizadoProjection> findAllMinimizadoSimilar(String nome, Pageable pageable) {
        return repository.findAllMinimizadoSimilar(nome, pageable);
    }

    public Page<ProdutoMinimizadoProjection> findAllMinimizadoDestaques(Pageable pageable) {
        return repository.findAllMinimizadoDestaques(pageable);
    }
}
