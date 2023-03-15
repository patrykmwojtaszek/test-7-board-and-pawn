package pl.kurs.test7boardandpawn.service;

import pl.kurs.test7boardandpawn.model.Board;
import pl.kurs.test7boardandpawn.model.Pawn;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface ImageService {

    BufferedImage createImageWithText(Board board, Pawn pawn);

}
