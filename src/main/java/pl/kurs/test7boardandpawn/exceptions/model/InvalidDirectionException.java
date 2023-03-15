package pl.kurs.test7boardandpawn.exceptions.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDirectionException extends IllegalArgumentException {

    public InvalidDirectionException(String message) {
        super(message);
    }
}
