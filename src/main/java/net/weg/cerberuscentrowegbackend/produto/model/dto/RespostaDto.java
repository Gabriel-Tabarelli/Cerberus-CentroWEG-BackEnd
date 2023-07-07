package net.weg.cerberuscentrowegbackend.produto.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespostaDto {

    @NotNull
    private Pessoa pessoa;

    @NotNull
    private String resposta;
}