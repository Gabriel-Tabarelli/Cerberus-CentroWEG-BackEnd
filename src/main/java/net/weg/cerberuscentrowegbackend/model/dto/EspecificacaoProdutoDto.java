package net.weg.cerberuscentrowegbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecificacaoProdutoDto {

    @NotNull
    private String especificacao;

}
