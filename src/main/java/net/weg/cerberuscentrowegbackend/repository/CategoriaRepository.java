package net.weg.cerberuscentrowegbackend.repository;

import net.weg.cerberuscentrowegbackend.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
