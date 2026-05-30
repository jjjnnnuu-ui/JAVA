import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {
    String path = ".\\data\\";
    String fileName = "barcode128(text).png";

    File file = new File(path + fileName);
    if (file.exists()) {
        ZXingHandler handler = new ZXingHandler();
        handler.decoding(file);
    } else {
        System.out.println("파일이 존재하지 않아요");
    }
}
