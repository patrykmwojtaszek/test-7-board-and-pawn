package pl.kurs.test7boardandpawn.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.test7boardandpawn.exceptions.model.InvalidPositionException;
import pl.kurs.test7boardandpawn.model.Board;
import pl.kurs.test7boardandpawn.model.Direction;
import pl.kurs.test7boardandpawn.model.Pawn;
import pl.kurs.test7boardandpawn.service.MailService;
import pl.kurs.test7boardandpawn.service.MailTimerTask;
import pl.kurs.test7boardandpawn.service.PawnService;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;

@Service
@RequiredArgsConstructor
@Getter
public class PawnServiceImpl implements PawnService {

    private final Pawn pawn = new Pawn(0,0);
    private final Board board = new Board(5, 5, pawn);
    private final ImageServiceImpl imageService;

    @Override
    public Pawn getPawn() {
        return pawn;
    }

    @Override
    public synchronized Pawn movePawn(String direction) {
        if (pawn.getPositionX() == 0 & pawn.getPositionY() == 0) imageService.doScreenshot(board,pawn);

        switch (direction) {
            case "UP" -> movePawnUp(pawn);
            case "DOWN" -> movePawnDown(pawn);
            case "LEFT" -> movePawnLeft(pawn);
            case "RIGHT" -> movePawnRight(pawn);
        }

        imageService.doScreenshot(board, pawn);
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
}
