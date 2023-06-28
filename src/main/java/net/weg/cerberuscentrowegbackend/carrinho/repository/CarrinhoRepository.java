package net.weg.cerberuscentrowegbackend.carrinho.repository;

import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
