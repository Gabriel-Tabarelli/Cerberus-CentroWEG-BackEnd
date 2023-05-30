package net.weg.cerberuscentrowegbackend.repository;

import net.weg.cerberuscentrowegbackend.model.entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
