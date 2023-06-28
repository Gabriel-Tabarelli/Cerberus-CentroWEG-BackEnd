package net.weg.cerberuscentrowegbackend.pessoa.repository;

import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    Optional<PessoaFisica> findByCpf(String cpf);

    void deleteByCpf(String cpf);

    boolean existsByCpf(String cpf);

}
