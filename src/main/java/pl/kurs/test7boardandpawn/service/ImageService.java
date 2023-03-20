package pl.kurs.test7boardandpawn.service;

import pl.kurs.test7boardandpawn.model.Board;
import pl.kurs.test7boardandpawn.model.Pawn;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public interface ImageService {

    void doScreenshot(Board board, Pawn pawn);
    BufferedImage getBufferedImage(Board board, Pawn pawn);
//    File getGifFile(Board board, Pawn pawn);
    File getGifFile();

}
