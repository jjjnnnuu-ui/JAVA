public class Main {
    public static void main(String[] args) {
        Book book = new Book("자바의 정석");

        Student student = new Student("김철수");
        Teacher teacher = new Teacher("김철수", "JAVA");

        teacher.teach();
        student.study(book);
    }
}