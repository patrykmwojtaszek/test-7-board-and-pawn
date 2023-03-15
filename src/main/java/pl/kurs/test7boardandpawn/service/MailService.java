package pl.kurs.test7boardandpawn.service;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public interface MailService {

//    void sendMail(String mailAddressTo, int x, int y);
    void sendMailWithAttachment(String mailAddressTo, int x, int y, File file) throws MessagingException;

}
