package net.weg.cerberuscentrowegbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.model.entity.Usuario;

import java.util.List;

@Data
@AllArgsConstructor
public class CarrinhoDto {

    private List<Produto> produtos;

    @NotNull
    private Usuario usuario;

}
