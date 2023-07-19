package net.weg.cerberuscentrowegbackend.categoria.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categoria {

    @Id
    private String nome;

    private String urlIcone;

    @ManyToOne
    private Categoria categoria;

}