package net.weg.cerberuscentrowegbackend.produto.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @Column(nullable = false)
    private String resposta;

    public Resposta(Pessoa pessoa, String resposta) {
        this.pessoa = pessoa;
        this.resposta = resposta;
    }

}
