package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria findOne(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            return categoriaOptional.get();
        }
        throw new RuntimeException("Categoria não encontrado!");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Boolean delete(Long id) {
        categoriaRepository.deleteById(id);
        return !categoriaRepository.existsById(id);
    }

}
