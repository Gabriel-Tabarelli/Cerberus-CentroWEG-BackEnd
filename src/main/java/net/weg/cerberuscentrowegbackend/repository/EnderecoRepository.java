package net.weg.cerberuscentrowegbackend.repository;

import net.weg.cerberuscentrowegbackend.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
