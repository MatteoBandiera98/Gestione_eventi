package progettofinale.Gestione_eventi.exceptions;




public class MyBadRequestException extends RuntimeException{
    public MyBadRequestException(String message) {
        super(message);
    }
}