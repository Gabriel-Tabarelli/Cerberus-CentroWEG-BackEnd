package net.weg.cerberuscentrowegbackend.resposta.repository;

import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
