package net.weg.cerberuscentrowegbackend.model.entity.websocket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.pessoa.Pessoa;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Pessoa pessoa;

    @Column(nullable = false)
    private String resposta;

}
