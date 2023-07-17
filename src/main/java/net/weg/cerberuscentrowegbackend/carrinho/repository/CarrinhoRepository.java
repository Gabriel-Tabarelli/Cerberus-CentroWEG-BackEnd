package net.weg.cerberuscentrowegbackend.carrinho.repository;

import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.carrinho.model.projectin.CarrinhoIdProdutosProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    Optional<CarrinhoIdProdutosProjection> findCarrinhoByPessoa_Id(Long id);

    Optional<Carrinho> findByPessoa_Id(Long id);

}
