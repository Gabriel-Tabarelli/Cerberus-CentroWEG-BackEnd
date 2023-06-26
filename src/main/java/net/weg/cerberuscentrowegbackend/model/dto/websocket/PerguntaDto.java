package net.weg.cerberuscentrowegbackend.model.dto.websocket;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;


@Data
@AllArgsConstructor
public class PerguntaDto {

//    @OneToOne
//    @Column(nullable = false)
//    private Pessoa pessoa;

    @NotNull
    private Produto produto;

    @NotNull
    private String pergunta;

}
