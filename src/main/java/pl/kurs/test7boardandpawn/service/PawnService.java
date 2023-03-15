package pl.kurs.test7boardandpawn.service;

import pl.kurs.test7boardandpawn.model.Direction;
import pl.kurs.test7boardandpawn.model.Pawn;
import pl.kurs.test7boardandpawn.model.dto.PawnDto;

public interface PawnService {

    Pawn getPawn();
    Pawn movePawn(String direction);
//    void sendMail(String mailAddressTo, Pawn pawn);
    void sendMailWithAttachment(String mailAddressTo, Pawn pawn);

}
