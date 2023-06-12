package net.weg.cerberuscentrowegbackend.model.entity.pessoa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.model.entity.Endereco;

@MappedSuperclass
@Data
public abstract class Pessoa {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToOne
    private Endereco endereco;

    @Column(nullable = false)
    @Size(max = 15)
    private String telefone;

}
