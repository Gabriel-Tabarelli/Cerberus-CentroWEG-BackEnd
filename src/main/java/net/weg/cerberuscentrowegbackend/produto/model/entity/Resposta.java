package net.weg.cerberuscentrowegbackend.produto.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.produto.model.dto.RespostaDto;

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

    @ManyToOne
    private Pergunta pergunta;

    public Resposta(RespostaDto respostaDto, Long idPergunta) {
        this.resposta = respostaDto.getResposta();
        this.pessoa = new Pessoa(respostaDto.getIdPessoa());
        this.pergunta = new Pergunta(idPergunta);
    }

}
