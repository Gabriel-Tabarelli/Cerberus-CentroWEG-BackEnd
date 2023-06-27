package net.weg.cerberuscentrowegbackend.service.websocket;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.websocket.Pergunta;
import net.weg.cerberuscentrowegbackend.repository.websocket.PerguntaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerguntaService {

    private PerguntaRepository perguntaRepository;

    public Pergunta save(Pergunta pergunta) {
        return perguntaRepository.save(pergunta);
    }

    public Page<Pergunta> getAll(int pagina) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(pagina, 3, sort);
        return perguntaRepository.findAll(pageable);
    }

}
