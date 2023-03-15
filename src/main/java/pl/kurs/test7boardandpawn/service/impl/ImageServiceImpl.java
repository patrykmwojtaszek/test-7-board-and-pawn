package pl.kurs.test7boardandpawn.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.test7boardandpawn.model.Board;
import pl.kurs.test7boardandpawn.model.Pawn;
import pl.kurs.test7boardandpawn.service.ImageService;

import java.awt.*;
import java.awt.image.BufferedImage;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Override
    public BufferedImage createImageWithText(Board board, Pawn pawn) {
        BufferedImage bufferedImage = new BufferedImage(board.getDimensionM() * 100 + 100,board.getDimensionN() * 100 + 100 ,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        for (int i = 0; i <= board.getDimensionM(); i++) {
            g.drawString( "" + i , i * 100 + 20,20);
        }
        for (int i = 0; i <= board.getDimensionN(); i++) {
            g.drawString( "" + i , 20, i * 100 + 20);
        }
        g.drawString("*PAWN (" + pawn.getPositionX() + ", " + pawn.getPositionY() + ")", pawn.getPositionX() * 100 + 40, pawn.getPositionY() * 100 + 20);

        return bufferedImage;
    }
}
