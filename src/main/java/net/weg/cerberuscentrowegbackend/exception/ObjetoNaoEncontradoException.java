package net.weg.cerberuscentrowegbackend.exception;

public class ObjetoNaoEncontradoException extends RuntimeException {
    public ObjetoNaoEncontradoException() {
        super("Objeto não encontrado!");
    }
}
