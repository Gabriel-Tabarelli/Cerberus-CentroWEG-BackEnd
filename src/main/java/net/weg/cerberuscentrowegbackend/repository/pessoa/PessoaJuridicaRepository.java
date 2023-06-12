package net.weg.cerberuscentrowegbackend.repository.pessoa;

import net.weg.cerberuscentrowegbackend.model.entity.pessoa.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, String> {
}
