package net.weg.cerberuscentrowegbackend.produto.repository;

import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByNome(String nome);

    Optional<ProdutoSemPerguntasProjection> findProdutoByNome(String nome);

    List<ProdutoMinimizadoProjection> findAllBy();

    Page<ProdutoPerguntasProjection> findAllByNome(String nome, Pageable pageable);

}
