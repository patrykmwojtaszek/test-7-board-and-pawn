package pl.kurs.test7boardandpawn.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.TimerTask;

@Service
@RequiredArgsConstructor
public class MailTimerTask extends TimerTask {

    private ImageService imageService;
    private MailService mailService;
    private String mailAddress;

    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public void run() {
        File gifFile = imageService.getGifFile();
        mailService.sendMailWithAttachment(mailAddress, gifFile);
    }
}
