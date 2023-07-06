package net.weg.cerberuscentrowegbackend.pessoa.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;

import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @ManyToMany
    private List<Produto> favoritos;

    /*Fazer uma tabela de conexões entre um produto e um usuário para buscar essa tabela ao
    logar e inscrever-se nos tópicos necessários para receber notificações,etc.*/

}
