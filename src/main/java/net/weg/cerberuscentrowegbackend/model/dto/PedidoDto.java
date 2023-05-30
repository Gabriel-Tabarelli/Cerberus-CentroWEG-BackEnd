package net.weg.cerberuscentrowegbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Carrinho;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {

    @NotNull
    private Carrinho carrinho;

}
