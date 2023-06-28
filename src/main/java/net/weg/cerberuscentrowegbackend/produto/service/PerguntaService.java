package net.weg.cerberuscentrowegbackend.produto.service;

import com.sun.jdi.ObjectCollectedException;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.produto.repository.PerguntaRepository;
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

    public Page<Pergunta> getAll(String nomeProduto, int pagina) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(pagina, 3, sort);
        return perguntaRepository.findAllByProduto_Nome(nomeProduto, pageable);
    }

    public Pergunta getOne(Long id) {
        return perguntaRepository.findById(id).orElseThrow(ObjectCollectedException::new);
    }

}
