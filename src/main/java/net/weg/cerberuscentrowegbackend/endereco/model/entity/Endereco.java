package net.weg.cerberuscentrowegbackend.endereco.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private Integer numero;

    @Column(length = 9)
    @Pattern(regexp = "^\\d{8}$")
    private String cep;

    @Column     
    private String complemento;


}
