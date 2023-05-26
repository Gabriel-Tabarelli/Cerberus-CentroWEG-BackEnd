package net.weg.cerberuscentrowegbackend.repository;


import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto, Long> {


}
