package net.weg.cerberuscentrowegbackend.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.model.entity.EspecificacaoProduto;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {

    @NotNull
    private String nome;

    @NotNull
    private String urlImagem;

    @NotNull
    private String descricao;

    @NotNull
    private Categoria categoria;

    private List<EspecificacaoProduto> especificacoes;

}
