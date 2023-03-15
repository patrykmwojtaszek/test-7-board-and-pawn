package pl.kurs.test7boardandpawn.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.test7boardandpawn.exceptions.model.InvalidDirectionException;
import pl.kurs.test7boardandpawn.exceptions.model.InvalidPositionException;
import pl.kurs.test7boardandpawn.model.Board;
import pl.kurs.test7boardandpawn.model.Direction;
import pl.kurs.test7boardandpawn.model.Pawn;
import pl.kurs.test7boardandpawn.model.dto.PawnDto;
import pl.kurs.test7boardandpawn.service.MailService;
import pl.kurs.test7boardandpawn.service.PawnService;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PawnServiceImpl implements PawnService {

    private final Pawn pawn = new Pawn(0,0);
    private final Board board = new Board(5, 5, pawn);
    private final MailService mailService;
    private final ImageServiceImpl imageService;

    @Override
    public Pawn getPawn() {
        return pawn;
    }

    @Override
    @Transactional
    public Pawn movePawn(String direction) {
        if (direction.equals(Direction.UP.toString())) movePawnUp(pawn);
        if (direction.equals(Direction.DOWN.toString())) movePawnDown(pawn);
        if (direction.equals(Direction.LEFT.toString())) movePawnLeft(pawn);
        if (direction.equals(Direction.RIGHT.toString())) movePawnRight(pawn);
        return pawn;
    }

    private void movePawnUp(Pawn pawn){
        if (pawn.getPositionY() <= 0) {
            throw new InvalidPositionException("Invalid Position");
        }
        pawn.setPositionY(pawn.getPositionY() - 1);
    }

    private void movePawnDown(Pawn pawn){
        if (pawn.getPositionY() >= board.getDimensionN()) {
            throw new InvalidPositionException("Invalid Position");
        }
        pawn.setPositionY(pawn.getPositionY() + 1);
    }

    private void movePawnLeft(Pawn pawn){
        if (pawn.getPositionX() <= 0) {
            throw new InvalidPositionException("Invalid Position");
        }
        pawn.setPositionX(pawn.getPositionX() - 1);
    }

    private void movePawnRight(Pawn pawn){
        if (pawn.getPositionX() >= board.getDimensionM()) {
            throw new InvalidPositionException("Invalid Position");
        }
        pawn.setPositionX(pawn.getPositionX() + 1);
    }

//    @Override
//    public void sendMail(String mailAddressTo, Pawn pawn) {
//        mailService.sendMail(mailAddressTo, pawn.getPositionX(), pawn.getPositionY());
//    }

    @Override
    public void sendMailWithAttachment(String mailAddressTo, Pawn pawn) {

        BufferedImage bufferedImage = imageService.createImageWithText(board, pawn);
        try {
            File outfile = new File("image.jpg");
            ImageIO.write(bufferedImage, "jpg", outfile);
            mailService.sendMailWithAttachment(mailAddressTo, pawn.getPositionX(), pawn.getPositionY(), outfile);
        } catch (MessagingException | IOException e) {
            e.getMessage();
        }
    }
}
