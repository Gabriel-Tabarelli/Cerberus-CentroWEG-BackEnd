package net.weg.cerberuscentrowegbackend.pergunta.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;

import java.util.List;


@Data
@AllArgsConstructor
public class PerguntaDto {

    @NotNull
    private Long idPessoa;

    @NotNull
    private String pergunta;

    private List<Resposta> listaRespostas;

}
