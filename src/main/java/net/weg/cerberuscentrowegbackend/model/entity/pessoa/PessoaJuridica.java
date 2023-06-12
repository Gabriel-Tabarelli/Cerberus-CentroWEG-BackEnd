package net.weg.cerberuscentrowegbackend.model.entity.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    @Id
    @Column(length = 14)
    @Pattern(regexp = "\\d{2}\\d{3}\\d{3}\\d{4}\\d{2}")
    private String cnpj;

}
