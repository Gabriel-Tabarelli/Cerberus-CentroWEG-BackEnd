package net.weg.cerberuscentrowegbackend.notificacao.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.notificacao.repository.NotificacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public NotificacaoProjection salvar(Notificacao notificacao) {
        Long id = repository.save(notificacao).getId();
        return repository.findNotificacaoById(id);
    }

    public void visualizarNotificacao(Long id) {
        Notificacao notificacao = repository.findById(id).orElseThrow();
        notificacao.setVisualizada(true);
        repository.save(notificacao);
    }

    public Page<NotificacaoProjection> buscarNotificacoes(Long id, Pageable page) {
        return repository.findNotificacaoByDestinatario_Id(id, page);
    }

    public Integer haNotificacoesNaoVisualizadas(Long id) {
        return repository.countByDestinatario_IdNotificacaoNaoVisualizada(id);
    }

}
