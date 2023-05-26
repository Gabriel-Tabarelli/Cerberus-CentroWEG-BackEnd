package net.weg.cerberuscentrowegbackend.repository;

import net.weg.cerberuscentrowegbackend.model.entity.EspecificacoesProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecificacoesProdutoRepo extends JpaRepository<EspecificacoesProduto, Long> {
}