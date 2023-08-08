package net.weg.cerberuscentrowegbackend.pergunta.repository;

import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.pergunta.model.projection.PerguntaProjection;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoPerguntasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

//    Page<Pergunta> findAllByProduto_Nome(String produto_nome, Pageable pageable);

    Page<PerguntaProjection> findAllByProduto_Id (Long id, Pageable pageable);
}
