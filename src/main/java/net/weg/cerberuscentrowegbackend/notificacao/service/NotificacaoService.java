package net.weg.cerberuscentrowegbackend.notificacao.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.entity.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.notificacao.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public NotificacaoProjection salvar(Notificacao notificacao) {
        Long id = repository.save(notificacao).getId();
        return repository.findNotificacaoById(id);
    }

}
