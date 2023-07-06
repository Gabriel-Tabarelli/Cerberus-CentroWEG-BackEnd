package net.weg.cerberuscentrowegbackend.produto.service;

import com.sun.jdi.ObjectCollectedException;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.repository.PerguntaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PerguntaService {

    private PerguntaRepository perguntaRepository;

    public Pergunta save(Pergunta pergunta) {
        return perguntaRepository.save(pergunta);
    }

    public Pergunta getOne(Long id) {
        return perguntaRepository.findById(id).orElseThrow(ObjectCollectedException::new);
    }

}
