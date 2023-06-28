package net.weg.cerberuscentrowegbackend.exception;

public class ObjetoInexistenteException extends RuntimeException {
    public ObjetoInexistenteException() {
        super("Objeto não encontrado!");
    }
}
