import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;


public class ExcelHandler {

    protected ArrayList<Student> readExcel(File file) {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            InputStream stream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream);
            XSSFSheet sheet = workbook.getSheet("학생성적");
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                String studentID = readData(row, 0);
                String name = readData(row, 1);
                String gender = readData(row, 2);
                Student student = new Student(name, gender);
                student.setStudentID(studentID);
                for (int j = 0; j < student.getSubjects().size();  j++ ) {
                    student.getSubject(j).setScore(Integer.parseInt(readData(row, j + 3)));
                }
                students.add(student);
            }
            if (students.isEmpty()) {
                System.out.println("데이터가 없습니다.");
                System.exit(-1);
            } else {
                System.out.printf("%s개의 데아터를 읽었습니다.\n", students.size());
            }
            bufferedInputStream.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    private String readData(XSSFRow row, int columnNum) {
        XSSFCell cell = row.getCell(columnNum);
        String value = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    value = ((int) cell.getNumericCellValue()) + "";
                    break;
            }
        }
        return value;
    }
}
