package net.weg.cerberuscentrowegbackend.pedido.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.pedido.model.dto.PedidoDto;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToMany
    private List<Produto> produtos;

    private String status;

    private String dataPedido;

    public Pedido(Carrinho carrinho) {
        this.pessoa = carrinho.getPessoa();
        this.produtos = new ArrayList<>(carrinho.getProdutos());
        this.status = "Aguardando pagamento";
        this.dataPedido = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy"));
    }
}
