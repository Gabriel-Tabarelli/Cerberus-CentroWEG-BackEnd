package net.weg.cerberuscentrowegbackend.pergunta.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.notificacao.model.Notificacao;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pergunta.model.dto.PerguntaDto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;

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
    private Pessoa perguntador;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    @JsonIgnore
    private Produto produto;

    @OneToMany
    @JoinColumn(name = "pergunta_id")
    private List<Resposta> listaRespostas;

    @Column(nullable = false)
    private String pergunta;

    public Pergunta(PerguntaDto perguntaDto, Long idProduto) {
        this.pergunta = perguntaDto.getPergunta();
        this.perguntador = new Pessoa(perguntaDto.getIdPessoa());
        this.produto = new Produto(idProduto);
    }

    public Pergunta(Long id) {
        this.id = id;
    }

}
