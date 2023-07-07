package net.weg.cerberuscentrowegbackend.categoria.repository;

import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByCategoria_Id(Long categoria_id);

}
