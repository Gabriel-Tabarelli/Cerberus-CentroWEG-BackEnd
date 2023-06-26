package net.weg.cerberuscentrowegbackend.service.websocket;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.websocket.Pergunta;
import net.weg.cerberuscentrowegbackend.repository.websocket.PerguntaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerguntaService {

    private PerguntaRepository perguntaRepository;

    public Pergunta create(Pergunta pergunta) {
        return perguntaRepository.save(pergunta);
    }

}
