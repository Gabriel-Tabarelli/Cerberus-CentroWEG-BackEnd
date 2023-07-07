package net.weg.cerberuscentrowegbackend.pessoa.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaFisica extends Pessoa{

    @Column(length = 11, unique = true)
    @Pattern(regexp = "^(\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2})|(\\d{11})$")
    private String cpf;

}
