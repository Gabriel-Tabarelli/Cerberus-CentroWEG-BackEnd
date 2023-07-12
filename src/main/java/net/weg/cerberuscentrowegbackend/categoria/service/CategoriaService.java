package net.weg.cerberuscentrowegbackend.categoria.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.categoria.repository.CategoriaRepository;
import net.weg.cerberuscentrowegbackend.produto.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private CategoriaRepository repository;
    private ProdutoService produtoService;

    public void save(Categoria categoria) {
        repository.save(categoria);
    }

    public void update(Categoria categoria) {
        repository.save(categoria);
    }

    public Categoria findOne(Long id) {
        return repository.findById(id).orElseThrow(
                ObjetoInexistenteException::new);
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<?> findCategorias(Long id) {
        List<Categoria> categorias = repository.findAllByCategoria_Id(id);
        if (categorias.isEmpty()) {
            return produtoService.findAllMinimizado(id);
        }
        return categorias;
    }
}
