//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {
       String path = ".\\data\\";
       String fileName = "bookInvoice.pdf";

       Book[] books = new Book[ ] {
               new Book("JAVA Programming 완전정복", 22000, 5,
                       "9788970502105"),
               new Book("Android Programming 완전정복", 32000, 5,
            "9788931462869")};
        ItextHandler itexthandler = new ItextHandler();
        itexthandler.makePDF(books, path + fileName);



}
