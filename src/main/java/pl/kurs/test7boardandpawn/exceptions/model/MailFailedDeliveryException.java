package pl.kurs.test7boardandpawn.exceptions.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.mail.MessagingException;

@ResponseStatus(HttpStatus.BAD_GATEWAY)
public class MailFailedDeliveryException extends RuntimeException {
}
