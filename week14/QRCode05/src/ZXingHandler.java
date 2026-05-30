import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ZXingHandler {

    protected void decoding(File file) {
        MultiFormatReader formatReader = new MultiFormatReader();
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            HybridBinarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = formatReader.decode(binaryBitmap, hints);
            System.out.println(result.getText());
            System.out.println(result.getBarcodeFormat());

        } catch (NotFoundException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
