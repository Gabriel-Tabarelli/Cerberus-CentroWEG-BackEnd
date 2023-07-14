package net.weg.cerberuscentrowegbackend.produto.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.produto.model.dto.PerguntaDto;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto produto;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pergunta_id")
    private List<Resposta> listaRespostas;

    @Column(nullable = false)
    private String pergunta;

    public Pergunta(PerguntaDto perguntaDto, Long idProduto) {
        this.pergunta = perguntaDto.getPergunta();
        this.pessoa = new Pessoa(perguntaDto.getIdPessoa());
        this.produto = new Produto(idProduto);
    }

    public Pergunta(Long id) {
        this.id = id;
    }

}
