package net.weg.cerberuscentrowegbackend.notificacao.repository;

import net.weg.cerberuscentrowegbackend.notificacao.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {
}
