package net.weg.cerberuscentrowegbackend.endereco.repository;

import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.endereco.projection.EnderecoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
