package net.weg.cerberuscentrowegbackend.notificacao.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;

@Entity
@Data
@NoArgsConstructor
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pergunta pergunta;

    @OneToOne
    private Resposta reposta;

    private Boolean visualizada;

    public Notificacao(Pergunta pergunta) {
        this.pergunta = pergunta;
        visualizada = false;
    }

    public Notificacao(Resposta resposta) {
        this.reposta = resposta;
        visualizada = false;
    }

}