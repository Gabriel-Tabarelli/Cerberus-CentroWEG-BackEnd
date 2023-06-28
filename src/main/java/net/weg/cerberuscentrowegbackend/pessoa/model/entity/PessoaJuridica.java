package net.weg.cerberuscentrowegbackend.pessoa.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class PessoaJuridica extends Pessoa{

    @Column(length = 14, unique = true)
    @Pattern(regexp = "\\d{2}\\d{3}\\d{3}\\d{4}\\d{2}")
    private String cnpj;

}
