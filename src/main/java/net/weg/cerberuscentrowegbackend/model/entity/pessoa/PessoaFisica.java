package net.weg.cerberuscentrowegbackend.model.entity.pessoa;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaFisica extends Pessoa{

    @Id
    @Column(length = 11)
    @Pattern(regexp = "^(\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2})|(\\d{11})$")
    private String cpf;

}
