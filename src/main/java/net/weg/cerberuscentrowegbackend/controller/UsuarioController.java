package net.weg.cerberuscentrowegbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.UsuarioDto;
import net.weg.cerberuscentrowegbackend.model.entity.Usuario;
import net.weg.cerberuscentrowegbackend.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody @Valid UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);
        return ResponseEntity.ok(usuarioService.create(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@RequestBody @Valid Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Boolean> delete(@PathVariable String cpf) {
        return ResponseEntity.ok(usuarioService.delete(cpf));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> findOne(@PathVariable String cpf) {
        return ResponseEntity.ok(usuarioService.findOne(cpf));
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

}
