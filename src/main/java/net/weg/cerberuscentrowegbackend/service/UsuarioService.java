package net.weg.cerberuscentrowegbackend.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Usuario;
import net.weg.cerberuscentrowegbackend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findOne(String cpf) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(cpf);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }
        throw new RuntimeException("Usuario não encontrado!");
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Boolean delete(String cpf) {
        usuarioRepository.deleteById(cpf);
        return !usuarioRepository.existsById(cpf);
    }

}
