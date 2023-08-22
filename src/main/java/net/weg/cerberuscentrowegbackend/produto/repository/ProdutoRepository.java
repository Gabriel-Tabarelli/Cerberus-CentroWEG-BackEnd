package net.weg.cerberuscentrowegbackend.produto.repository;

import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoSemPerguntasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<ProdutoSemPerguntasProjection> findProdutoById(Long id);

    List<ProdutoMinimizadoProjection> findAllBy();

    List<ProdutoMinimizadoProjection> findAllByCategoria_Nome(String categoria_id);

    List<ProdutoMinimizadoProjection> findAllByNomeContainingIgnoreCaseOrCategoria_NomeContainingIgnoreCase(String nome, String categoria_nome);

    @Query("SELECT p " +
            "FROM Produto p " +
            "ORDER BY p.qtdVendas DESC")
    Page<ProdutoMinimizadoProjection> findAllMinimizadoMaisVendidos(Pageable pageable);

    @Query("SELECT p " +
            "FROM Produto p " +
            "ORDER BY p.id DESC")
    Page<ProdutoMinimizadoProjection> findAllMinimizadoMaisRecentes(Pageable pageable);

    @Query("SELECT p " +
            "FROM Produto p " +
            "WHERE p.nome LIKE %:nome% " +
            "ORDER BY p.qtdVendas DESC")
    Page<ProdutoMinimizadoProjection> findAllMinimizadoSimilar(String nome, Pageable pageable);

    @Query("SELECT p " +
            "FROM Produto p " +
            "ORDER BY p.nome ASC")
    Page<ProdutoMinimizadoProjection> findAllMinimizadoDestaques(Pageable pageable);

}
