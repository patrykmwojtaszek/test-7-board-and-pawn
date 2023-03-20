package pl.kurs.test7boardandpawn.service.impl;

import com.simiacryptus.util.io.GifSequenceWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.test7boardandpawn.model.Board;
import pl.kurs.test7boardandpawn.model.Pawn;
import pl.kurs.test7boardandpawn.service.ImageService;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final List<BufferedImage> bufferedImageList = new ArrayList<>();
    private File gifFile;

    @Override
    public void doScreenshot(Board board, Pawn pawn) {
        bufferedImageList.add(getBufferedImage(board, pawn));
    }

    @Override
    public BufferedImage getBufferedImage(Board board, Pawn pawn) {
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

    @Override
    public File getGifFile() {

        try {
            BufferedImage first = bufferedImageList.get(0);
            ImageOutputStream output = new FileImageOutputStream(new File("example.gif"));

            GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 500, true);
            writer.writeToSequence(first);

            for (int i = 1; i < bufferedImageList.size(); i++) {
                writer.writeToSequence(bufferedImageList.get(i));
            }

            writer.close();
            output.close();

            gifFile = new File("example.gif");
            ImageIO.read(gifFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gifFile;
    }
}
