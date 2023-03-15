package pl.kurs.test7boardandpawn.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.kurs.test7boardandpawn.exceptions.model.InvalidDirectionException;
import pl.kurs.test7boardandpawn.exceptions.model.InvalidPositionException;
import pl.kurs.test7boardandpawn.exceptions.model.dto.ExceptionResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({InvalidDirectionException.class, InvalidPositionException.class})
    public ResponseEntity<ExceptionResponseBody> handleCustomException(Exception e) {
        ExceptionResponseBody responseBody = new ExceptionResponseBody(
                List.of(e.getMessage()), "BAD_REQUEST", LocalDateTime.now()
        );
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionResponseBody> handleValidationException(MethodArgumentNotValidException e) {
        List<String> messages = e.getFieldErrors()
                .stream()
                .map(fe -> "Field: " + fe.getField() + "; rejected value: '" + fe.getRejectedValue() + "'; message: " + fe.getDefaultMessage())
                .collect(Collectors.toList());
        ExceptionResponseBody responseBody = new ExceptionResponseBody(messages, "BAD_REQUEST", LocalDateTime.now());
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);

    }



}
