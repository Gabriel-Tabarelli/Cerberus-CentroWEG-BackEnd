package net.weg.cerberuscentrowegbackend.model.dto.websocket;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PerguntaDto {

//    @OneToOne
//    @Column(nullable = false)
//    private Pessoa pessoa;

    @NotNull
    private String pergunta;

}
