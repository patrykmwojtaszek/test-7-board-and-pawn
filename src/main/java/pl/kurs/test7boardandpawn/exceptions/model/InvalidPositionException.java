package pl.kurs.test7boardandpawn.exceptions.model;


public class InvalidPositionException extends IllegalArgumentException{
    public InvalidPositionException(String message) {
        super(message);
    }
}
