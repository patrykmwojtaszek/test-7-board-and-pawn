package pl.kurs.test7boardandpawn.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.kurs.test7boardandpawn.exceptions.model.MailFailedDeliveryException;
import pl.kurs.test7boardandpawn.service.MailService;
import pl.kurs.test7boardandpawn.service.MailTimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final ImageServiceImpl imageService;
    private final JavaMailSender javaMailSender;
    private final MailTimerTask mailTimerTask;


    @Override
    @Transactional
    public void startMailTimerTask(String mailAddressTo) {

        mailTimerTask.setImageService(imageService);
        mailTimerTask.setMailService(this);
        mailTimerTask.setMailAddress(mailAddressTo);

        mailTimerTask.run();

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(mailTimerTask, getToday23h59m(), 1000*60*60*24);

    }

    private static Date getToday23h59m(){
        Calendar today = new GregorianCalendar();
        Calendar result = new GregorianCalendar(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DATE),
                23,
                50
        );
        return result.getTime();
    }



    @Override
    public void sendMailWithAttachment(String mailAddressTo, File file)  {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("jk3539727@gmail.com");
            helper.setTo(mailAddressTo);
            helper.setSubject("Board And Pawn");
            helper.setText("");
            helper.addAttachment("GIF", file);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        try {
            javaMailSender.send(message);
        } catch (MailFailedDeliveryException e) {
            e.printStackTrace();
        }
    }
}
