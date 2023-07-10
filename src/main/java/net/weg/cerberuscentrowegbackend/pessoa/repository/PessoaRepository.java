package net.weg.cerberuscentrowegbackend.pessoa.repository;

import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
