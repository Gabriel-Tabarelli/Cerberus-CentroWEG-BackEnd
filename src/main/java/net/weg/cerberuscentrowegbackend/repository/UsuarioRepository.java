package net.weg.cerberuscentrowegbackend.repository;

import net.weg.cerberuscentrowegbackend.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
