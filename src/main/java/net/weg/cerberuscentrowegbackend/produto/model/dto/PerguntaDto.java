package net.weg.cerberuscentrowegbackend.produto.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;


@Data
@AllArgsConstructor
public class PerguntaDto {

    @NotNull
    private Pessoa pessoa;

    @NotNull
    private String pergunta;

}
