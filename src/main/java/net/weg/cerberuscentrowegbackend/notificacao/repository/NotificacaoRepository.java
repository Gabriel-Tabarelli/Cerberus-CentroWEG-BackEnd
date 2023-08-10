package net.weg.cerberuscentrowegbackend.notificacao.repository;

import net.weg.cerberuscentrowegbackend.notificacao.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    NotificacaoProjection findNotificacaoById(Long id);

}
