package net.weg.cerberuscentrowegbackend.produto.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String urlImagem;

    @Column(length = 500)
    private String descricao;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")
    private List<EspecificacaoProduto> especificacoes;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Pergunta> perguntas;

    private Integer qtdVendas;

    public Produto(Long id) {
        this.id = id;
    }

}
