package net.weg.cerberuscentrowegbackend.pessoa.repository;

import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNotificacoesProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByEmailAndSenha(String email, String senha);

    List<Pessoa> findAllByAdmin(Boolean admin);

    PessoaNotificacoesProjection findPessoaById(Long id);

}
