package net.weg.cerberuscentrowegbackend.notificacao.repository;

import net.weg.cerberuscentrowegbackend.notificacao.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    NotificacaoProjection findNotificacaoById(Long id);

    @Query("SELECT n " +
            "FROM Notificacao n " +
            "JOIN n.destinatario d " +
            "WHERE d.id = :id " +
            "ORDER BY n.data DESC")
    Page<NotificacaoProjection> findNotificacaoByDestinatario_Id(
            @Param("id") Long id,
            Pageable page);

    @Query("SELECT exists (SELECT n " +
            "FROM Notificacao n " +
            "JOIN n.destinatario d " +
            "WHERE d.id = :id " +
            "AND n.visualizada = false " +
            "ORDER BY n.data DESC)")
    Boolean existsByDestinatario_IdNotificacaoNaoVisualizada(@Param("id") Long id);
}
