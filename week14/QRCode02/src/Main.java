import com.google.zxing.BarcodeFormat;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {
       String path = ".\\data\\";
       String fileName = "barcode128(text).png";
       Scanner keyboard = new Scanner(System.in);
       String data;

       while (true) {
           System.out.print("Barcode 문자열 입력(영문자 숫자) : ");
           data = keyboard.nextLine();
           if (data != null) {
               break;
           }
       }

       ZXingHandler handler = new ZXingHandler();
       handler.encoding(data, BarcodeFormat.CODE_128, path + fileName);

}
