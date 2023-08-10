package net.weg.cerberuscentrowegbackend.notificacao.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.Notificacao;
import net.weg.cerberuscentrowegbackend.notificacao.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository repository;

    public void salvar(Notificacao notificacao) {
        repository.save(notificacao);
    }

}
