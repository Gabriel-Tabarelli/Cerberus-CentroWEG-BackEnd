package net.weg.cerberuscentrowegbackend.endereco.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

    @NotNull
    private String estado;

    @NotNull
    private String cidade;

    @NotNull
    private String bairro;

    @NotNull
    private String rua;

    @NotNull
    private Integer numero;

    @NotNull
    private String cep;

    private String complemento;

}
