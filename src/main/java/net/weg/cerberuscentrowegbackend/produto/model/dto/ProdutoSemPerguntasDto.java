package net.weg.cerberuscentrowegbackend.produto.model.dto;

import lombok.Data;
import net.weg.cerberuscentrowegbackend.categoria.model.entity.Categoria;
import net.weg.cerberuscentrowegbackend.produto.model.entity.EspecificacaoProduto;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;

import java.util.List;

@Data
public class ProdutoSemPerguntasDto {

    private Long id;

    private String nome;

    private String urlImagem;

    private String descricao;

    private Categoria categoria;

    public ProdutoSemPerguntasDto(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.urlImagem = produto.getUrlImagem();
        this.descricao = produto.getDescricao();
        this.categoria = produto.getCategoria();
        List<EspecificacaoProduto> especificacoes = produto.getEspecificacoes();
    }
    
}
