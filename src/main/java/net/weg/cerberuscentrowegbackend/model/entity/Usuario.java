package net.weg.cerberuscentrowegbackend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {

    @Id
    @Column(length = 11)
    @Pattern(regexp = "^(\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2})|(\\d{11})$")
    private String cpf;

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
