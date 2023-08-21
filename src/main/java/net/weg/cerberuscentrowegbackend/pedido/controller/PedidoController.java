package net.weg.cerberuscentrowegbackend.pedido.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.pedido.model.dto.PedidoDto;
import net.weg.cerberuscentrowegbackend.pedido.model.entity.Pedido;
import net.weg.cerberuscentrowegbackend.pedido.model.projection.PedidoListaProjection;
import net.weg.cerberuscentrowegbackend.pedido.model.projection.PedidoProjection;
import net.weg.cerberuscentrowegbackend.pedido.service.PedidoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping("/{idCarrinho}")
    public ResponseEntity<Void> save(@PathVariable Long idCarrinho) {
        pedidoService.save(idCarrinho);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoProjection> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.findOne(id));
    }

    @GetMapping("/getAll/{pessoaId}")
    public ResponseEntity<Page<PedidoListaProjection>> findAll(@PathVariable Long pessoaId,
                                                               @RequestParam("page") Integer page,
                                                               @RequestParam("sort") String ordem) {
        return ResponseEntity.ok(pedidoService.findAll(pessoaId, page, ordem));
    }

}
