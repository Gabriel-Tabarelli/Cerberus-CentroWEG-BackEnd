package net.weg.cerberuscentrowegbackend.pedido.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pedido.model.dto.PedidoDto;
import net.weg.cerberuscentrowegbackend.pedido.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.pedido.service.PedidoService;
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
    public ResponseEntity<Void> save(@RequestBody @Valid PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(pedidoDto, pedido);
        pedidoService.save(pedido);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid Pedido pedido) {
        pedidoService.update(pedido);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findOne(id));
    }
    
}
