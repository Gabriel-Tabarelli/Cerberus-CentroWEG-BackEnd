package net.weg.cerberuscentrowegbackend.pessoa.repository;

import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    Optional<PessoaJuridica> findByCnpj(String cnpj);

    void deleteByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);

}
