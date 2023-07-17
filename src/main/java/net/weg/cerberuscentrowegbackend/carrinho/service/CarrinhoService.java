package net.weg.cerberuscentrowegbackend.carrinho.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.projectin.CarrinhoIdProdutosProjection;
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

    public Carrinho findOne(Long id) {
        return carrinhoRepository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public CarrinhoIdProdutosProjection findOneProjection(Long idPessoa) {
        return carrinhoRepository.findCarrinhoByPessoa_Id(idPessoa).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public void addRmProduto(Carrinho carrinho, Produto produto) {
        if (carrinho.getProdutos().contains(produto)) {
            carrinho.getProdutos().remove(produto);
        } else {
            carrinho.getProdutos().add(produto);
        }
        carrinhoRepository.save(carrinho);
    }
}
