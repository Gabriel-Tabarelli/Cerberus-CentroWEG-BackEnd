package net.weg.cerberuscentrowegbackend.produto.repository;

import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecificacaoProdutoRepository extends JpaRepository<EspecificacaoProduto, Long> {
}
