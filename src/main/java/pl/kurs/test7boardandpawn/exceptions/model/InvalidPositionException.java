package pl.kurs.test7boardandpawn.exceptions.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPositionException extends IllegalArgumentException{
    public InvalidPositionException(String message) {
        super(message);
    }
}
