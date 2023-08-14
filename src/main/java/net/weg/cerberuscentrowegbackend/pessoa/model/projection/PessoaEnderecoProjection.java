package net.weg.cerberuscentrowegbackend.pessoa.model.projection;

import net.weg.cerberuscentrowegbackend.endereco.model.entity.Endereco;
import net.weg.cerberuscentrowegbackend.endereco.projection.EnderecoProjection;

public interface PessoaEnderecoProjection {

    EnderecoProjection getEndereco();
}
