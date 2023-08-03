package net.weg.cerberuscentrowegbackend.carrinho.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;

import java.util.List;

@Data
public class CarrinhoDto {

    private List<Produto> produtos;

    @NotNull
    private Pessoa pessoa;

}
