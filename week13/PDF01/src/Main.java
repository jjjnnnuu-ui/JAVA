//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
void main() {
    String path = ".\\data\\";
    String excelFile = "student.xlsx";
    String pdfFile = "student.pdf";


    ArrayList<Student> students;

    File file = new File(path + excelFile);
    if (file.exists()) {
       ExcelHandler handler = new ExcelHandler();
       students = handler.readExcel(file);

       ClassRoom classRoom = new ClassRoom(students);
       classRoom.sortByGenderAndSum();

       PDFHandler pdfHandler = new PDFHandler();
       pdfHandler.makePDF(path + pdfFile, students);
    } else {
        System.out.printf("%s File이 존재하지 않아요\n", path + excelFile);
    }
}
