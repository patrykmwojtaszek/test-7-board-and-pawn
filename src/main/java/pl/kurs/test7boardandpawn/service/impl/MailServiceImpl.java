package pl.kurs.test7boardandpawn.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.kurs.test7boardandpawn.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

//    @Override
//    public void sendMail(String mailAddressTo, int x, int y) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(mailAddressTo);
//        message.setSubject("Board And Pawn");
//        message.setText("Position of the pawn is x: " + x + " y: " + y);
//        javaMailSender.send(message);
//    }

    @Override
    public void sendMailWithAttachment(String mailAddressTo, int x, int y, File file) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("jk3539727@gmail.com");
        helper.setTo(mailAddressTo);
        helper.setSubject("Board And Pawn");
        helper.setText("Position of the pawn is x: " + x + " y: " + y);

//        FileSystemResource file
//                = new FileSystemResource(new File(pathToAttachment));
        helper.addAttachment("GIF", file);

        javaMailSender.send(message);
    }
}
