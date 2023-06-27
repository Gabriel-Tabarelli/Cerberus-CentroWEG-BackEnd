package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoNaoEncontradoException;
import net.weg.cerberuscentrowegbackend.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria findOne(Long id) {
        return categoriaRepository.findById(id).orElseThrow(
                ObjetoNaoEncontradoException::new);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Boolean delete(Long id) {
        categoriaRepository.deleteById(id);
        return !categoriaRepository.existsById(id);
    }

}
