package net.weg.cerberuscentrowegbackend.carrinho.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.carrinho.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    public void save(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
    }

    public void update(Carrinho carrinho) {
        carrinhoRepository.save(carrinho);
    }

    public Carrinho findOne(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public void delete(Long id) {
        carrinhoRepository.deleteById(id);
    }

    public void addProduto(Carrinho carrinho, Produto produto) {
        carrinho.getProdutos().add(produto);
        carrinhoRepository.save(carrinho);
    }

    public void rmProduto(Carrinho carrinho, Produto produto) {
        carrinho.getProdutos().remove(produto);
        carrinhoRepository.save(carrinho);
    }
}
