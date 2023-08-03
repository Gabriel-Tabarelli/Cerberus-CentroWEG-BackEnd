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
        return carrinhoRepository.findByPessoa_Id(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

}
