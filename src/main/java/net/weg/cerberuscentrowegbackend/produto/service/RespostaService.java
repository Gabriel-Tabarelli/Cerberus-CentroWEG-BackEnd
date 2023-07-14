package net.weg.cerberuscentrowegbackend.produto.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Resposta;
import net.weg.cerberuscentrowegbackend.produto.repository.RespostaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RespostaService {

    private final RespostaRepository respostaRepository;

    public void save(Resposta resposta) {
        respostaRepository.save(resposta);
    }

}
