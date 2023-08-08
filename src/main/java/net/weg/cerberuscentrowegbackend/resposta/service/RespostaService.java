package net.weg.cerberuscentrowegbackend.resposta.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.resposta.repository.RespostaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RespostaService {

    private final RespostaRepository repository;

    public void save(Resposta resposta) {
        repository.save(resposta);
    }

}
