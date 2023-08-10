package net.weg.cerberuscentrowegbackend.resposta.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.resposta.model.dto.RespostaDto;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pessoa respondedor;

    @Column(nullable = false)
    private String resposta;

    @ManyToOne
    private Pergunta pergunta;

    public Resposta(RespostaDto respostaDto, Long idPergunta) {
        this.resposta = respostaDto.getResposta();
        this.respondedor = new Pessoa(respostaDto.getIdPessoa());
        this.pergunta = new Pergunta(idPergunta);
    }

}
