package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoNaoEncontradoException;
import net.weg.cerberuscentrowegbackend.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    public Carrinho save(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho update(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho findOne(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(
                ObjetoNaoEncontradoException::new);
    }

    public List<Carrinho> findAll() {
        return carrinhoRepository.findAll();
    }

    public Boolean delete(Long id) {
        carrinhoRepository.deleteById(id);
        return !carrinhoRepository.existsById(id);
    }

    public Carrinho addProduto(Carrinho carrinho, Produto produto) {
        carrinho.getProdutos().add(produto);
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho rmProduto(Carrinho carrinho, Produto produto) {
        carrinho.getProdutos().remove(produto);
        return carrinhoRepository.save(carrinho);
    }
}
