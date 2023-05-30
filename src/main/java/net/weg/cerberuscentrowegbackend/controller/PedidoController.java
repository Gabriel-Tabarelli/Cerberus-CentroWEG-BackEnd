package net.weg.cerberuscentrowegbackend.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.dto.PedidoDto;
import net.weg.cerberuscentrowegbackend.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.service.PedidoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody @Valid PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDto, pedido);
        return ResponseEntity.ok(pedidoService.create(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody @Valid Pedido pedido) {
        return ResponseEntity.ok(pedidoService.update(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findOne(id));
    }

    @GetMapping()
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }
    
}
