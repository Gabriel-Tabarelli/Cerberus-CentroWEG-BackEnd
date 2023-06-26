package net.weg.cerberuscentrowegbackend.repository.websocket;

import net.weg.cerberuscentrowegbackend.model.entity.websocket.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {
}
