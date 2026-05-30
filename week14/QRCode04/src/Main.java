//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {
    String path = ".\\data\\";
    String fileName = "QRCode01.png";
    Scanner keyboard = new Scanner(System.in);
    String data ="";

    while (true) {
        System.out.print("QRCODE 텍스트 입력 : ");
        data = keyboard.nextLine();
        if (!data.equals("")) {
            break;
        }
    }

    ZXingHandler handler = new ZXingHandler();
    handler.encoding(data, path + fileName);
}
