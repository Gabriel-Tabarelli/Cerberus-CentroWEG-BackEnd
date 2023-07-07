package net.weg.cerberuscentrowegbackend.produto.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @ManyToOne
    private Produto produto;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pergunta_id")
    private List<Resposta> listaRespostas;

    @Column(nullable = false)
    private String pergunta;

}
