package net.weg.cerberuscentrowegbackend.pessoa.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaFisicaRepository;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaJuridicaRepository;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaRepository;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PessoaService {

    private PessoaRepository repository;
    private PessoaJuridicaRepository juridicaRepository;
    private PessoaFisicaRepository fisicaRepository;

    private ProdutoService produtoService;

    public void save(PessoaJuridica pessoa) {
        juridicaRepository.save(pessoa);
    }

    public void save(PessoaFisica pessoa) {
        fisicaRepository.save(pessoa);
    }

    public Pessoa findOne(Long id) {
        return repository.findById(id).orElseThrow(ObjetoInexistenteException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public void adicionarFavorito(Long id, Long idProduto) {
        Pessoa pessoa = findOne(id);
        Produto produto = produtoService.findById(idProduto);
        if (pessoa.getFavoritos().contains(produto)) {
            throw new RuntimeException("Produto já está na lista de favoritos");
        } else {
            pessoa.getFavoritos().add(produto);
            update(pessoa);
        }
    }

    public void removerFavorito(Long id, Long idProduto) {
        Pessoa pessoa = findOne(id);
        Produto produto = produtoService.findById(idProduto);
        pessoa.getFavoritos().remove(produto);
        update(pessoa);
    }
}
