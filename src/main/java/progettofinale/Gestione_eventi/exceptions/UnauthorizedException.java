package progettofinale.Gestione_eventi.exceptions;



public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(String message) {
        super(message);
    }
}