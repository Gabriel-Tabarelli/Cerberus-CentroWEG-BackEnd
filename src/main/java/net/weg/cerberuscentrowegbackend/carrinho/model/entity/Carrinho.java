package net.weg.cerberuscentrowegbackend.carrinho.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Produto> produtos;

    @ManyToOne
    private Pessoa pessoa;

}
