package net.weg.cerberuscentrowegbackend.notificacao.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.pergunta.model.entity.Pergunta;
import net.weg.cerberuscentrowegbackend.resposta.model.entity.Resposta;

import java.time.LocalDate;

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
    private Resposta resposta;

    private Boolean visualizada;

    private LocalDate data;

    public Notificacao(Pergunta pergunta) {
        this.pergunta = pergunta;
        this.resposta = null;
        visualizada = false;
        this.data = LocalDate.now();
    }

    public Notificacao(Resposta resposta) {
        this.resposta = resposta;
        this.pergunta = null;
        visualizada = false;
        this.data = LocalDate.now();
    }

}
