package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdutoService {

    private ProdutoRepository produtoRepository;
    private EspecificacaoProdutoService especificacaoProdutoService;

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto update(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto findOne(Long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            return produtoOptional.get();
        }
        throw new RuntimeException("Produto não encontrado!");
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
