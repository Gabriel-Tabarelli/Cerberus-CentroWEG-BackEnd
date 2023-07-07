package net.weg.cerberuscentrowegbackend.produto.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.produto.model.projection.ProdutoMinimizadoProjection;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto implements ProdutoMinimizadoProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String urlImagem;

    @Column(length = 500)
    private String descricao;

    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private List<EspecificacaoProduto> especificacoes;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Pergunta> perguntas;

}
