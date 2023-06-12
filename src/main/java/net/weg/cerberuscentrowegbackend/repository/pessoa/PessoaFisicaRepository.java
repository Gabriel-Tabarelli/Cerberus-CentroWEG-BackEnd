package net.weg.cerberuscentrowegbackend.repository.pessoa;

import net.weg.cerberuscentrowegbackend.model.entity.pessoa.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, String> {
}
