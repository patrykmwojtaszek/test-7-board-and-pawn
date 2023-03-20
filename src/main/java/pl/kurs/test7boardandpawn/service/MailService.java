package pl.kurs.test7boardandpawn.service;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public interface MailService {

    void sendMailWithAttachment(String mailAddressTo, File file);
    void startMailTimerTask(String mailAddressTo);

}
