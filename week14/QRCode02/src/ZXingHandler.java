import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZXingHandler {

    protected void encoding(String data, BarcodeFormat format, String fileName) {
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = writer.encode(data, format, 300, 100);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight() + 30;
            BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = resizedImage.createGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.drawImage(bufferedImage, 0, 0, width, height, null);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Times New Roman", Font.PLAIN, 16));
            FontMetrics fm = graphics.getFontMetrics();
            int textWidth = fm.stringWidth(data);
            int x  = (width - textWidth) / 2;
            int y = (height - 10);
            graphics.drawString(data, x, y);
            graphics.dispose();

            Path path = Paths.get(fileName);
            javax.imageio.ImageIO.write(resizedImage, "PNG", path.toFile());
            System.out.println("Barcode 생성 완료");


        } catch (WriterException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
