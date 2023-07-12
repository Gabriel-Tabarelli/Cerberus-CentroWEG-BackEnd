package net.weg.cerberuscentrowegbackend.pessoa.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEditarDto {

    @NotNull
    private String nome;

    @NotNull
    private String senha;

    @NotNull
    private Endereco endereco;

    @NotNull
    private String telefone;

}
