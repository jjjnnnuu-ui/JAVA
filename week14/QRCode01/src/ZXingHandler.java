import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZXingHandler {

    protected void encoding(String data, BarcodeFormat format, String fileName){
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = writer.encode(data, format, 300, 100);

            Path path = Paths.get(fileName);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
            System.out.println("바코드 생성 완료");
        } catch (WriterException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
