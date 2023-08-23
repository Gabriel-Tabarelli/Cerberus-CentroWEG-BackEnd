package net.weg.cerberuscentrowegbackend.pessoa.service;

import lombok.AllArgsConstructor;
import net.weg.cerberuscentrowegbackend.carrinho.model.entity.Carrinho;
import net.weg.cerberuscentrowegbackend.carrinho.service.CarrinhoService;
import net.weg.cerberuscentrowegbackend.exception.ObjetoInexistenteException;
import net.weg.cerberuscentrowegbackend.notificacao.model.projection.NotificacaoProjection;
import net.weg.cerberuscentrowegbackend.notificacao.service.NotificacaoService;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.Pessoa;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaFisica;
import net.weg.cerberuscentrowegbackend.pessoa.model.entity.PessoaJuridica;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaNotificacoesProjection;
import net.weg.cerberuscentrowegbackend.pessoa.model.projection.PessoaEnderecoProjection;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaFisicaRepository;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaJuridicaRepository;
import net.weg.cerberuscentrowegbackend.pessoa.repository.PessoaRepository;
import net.weg.cerberuscentrowegbackend.produto.model.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final PessoaJuridicaRepository juridicaRepository;
    private final PessoaFisicaRepository fisicaRepository;
    private final CarrinhoService carrinhoService;
    private final NotificacaoService notificacaoService;

    public void save(PessoaJuridica pessoa) {
        juridicaRepository.save(pessoa);
        Carrinho carrinho = new Carrinho(pessoa);
        carrinhoService.save(carrinho);
    }

    public void save(PessoaFisica pessoa) {
        fisicaRepository.save(pessoa);
        Carrinho carrinho = new Carrinho(pessoa);
        carrinhoService.save(carrinho);
    }

    public Pessoa findOneByEmailAndSenha(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha).orElseThrow(ObjetoInexistenteException::new);
    }

    public Pessoa findOne(Long id) {
        return repository.findById(id).orElseThrow(ObjetoInexistenteException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void update(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public List<Pessoa> pegarAdmins() {
        return repository.findAllByAdmin(true);
    }

    public Page<NotificacaoProjection> buscarNotificacoes(Long id, Pageable page) {
        return notificacaoService.buscarNotificacoes(id, page);
    }

    public Integer haNotificacoesNaoVisualizadas(Long id) {
        return notificacaoService.haNotificacoesNaoVisualizadas(id);
    }

    public PessoaEnderecoProjection buscarEndereco(Long id){
        return repository.findPessoaById(id);
    }

    public void visualizarComentario(Long idNotificacao) {
        notificacaoService.visualizarNotificacao(idNotificacao);
    }

}
