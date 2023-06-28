package net.weg.cerberuscentrowegbackend.categoria.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.categoria.repository.CategoriaRepository;
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
                ObjetoInexistenteException::new);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Boolean delete(Long id) {
        categoriaRepository.deleteById(id);
        return !categoriaRepository.existsById(id);
    }

}
