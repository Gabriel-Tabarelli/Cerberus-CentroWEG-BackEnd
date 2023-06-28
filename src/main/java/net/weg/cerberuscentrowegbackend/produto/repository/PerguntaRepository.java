package net.weg.cerberuscentrowegbackend.produto.repository;

import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    Page<Pergunta> findAllByProduto_Nome(String produto_nome, Pageable pageable);

}
