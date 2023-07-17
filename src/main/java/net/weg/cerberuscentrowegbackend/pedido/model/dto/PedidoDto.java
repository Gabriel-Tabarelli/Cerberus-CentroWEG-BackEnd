package net.weg.cerberuscentrowegbackend.pedido.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    @NotNull
    private List<Produto> produtos;

    private Long idPessoa;

}
