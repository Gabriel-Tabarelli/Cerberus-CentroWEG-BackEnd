package net.weg.cerberuscentrowegbackend.pessoa.repository;

import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNotificacoesProjection;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaEnderecoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByEmailAndSenha(String email, String senha);

    List<Pessoa> findAllByAdmin(Boolean admin);

    @Query(value = "SELECT n " +
            " FROM Pessoa p " +
            "JOIN p.notificacoes n " +
            "WHERE p.id = :id " +
            "AND n.visualizada = :visualizada " +
            "ORDER BY n.data DESC")
    List<NotificacaoProjection> findPessoaByIdReturnPessoaNotificacoes(
            @Param("id") Long id, @Param("visualizada") boolean visualizada);
    // PEDIR PARA O TITIO GALI

    PessoaEnderecoProjection findPessoaById(Long id);

}
