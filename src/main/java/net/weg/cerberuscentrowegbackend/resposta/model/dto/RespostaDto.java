package net.weg.cerberuscentrowegbackend.resposta.model.dto;

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
    private Long idPessoa;

    @NotNull
    private String resposta;

    @NotNull
    private Long idPergunta;
}
