package net.weg.cerberuscentrowegbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Categoria;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {

    @NotNull
    private String nome;

    private Categoria categoria;

}
