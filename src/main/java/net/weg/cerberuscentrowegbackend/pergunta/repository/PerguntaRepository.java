package net.weg.cerberuscentrowegbackend.pergunta.repository;

import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    Page<Pergunta> findAllByProduto_Nome(String produto_nome, Pageable pageable);

}
