package net.weg.cerberuscentrowegbackend.model.entity.websocket;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Produto;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Column(nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private String notificacao;

}
