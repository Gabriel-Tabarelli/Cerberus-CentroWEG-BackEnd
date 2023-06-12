package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.repository.CarrinhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarrinhoService {

    private CarrinhoRepository carrinhoRepository;

    public Carrinho create(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho update(Carrinho carrinho) {
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho findOne(Long id) {
        Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
        if (carrinhoOptional.isPresent()) {
            return carrinhoOptional.get();
        }
        throw new RuntimeException("Carrinho não encontrado!");
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
