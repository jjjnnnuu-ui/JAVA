public class Main {
    public static void main(String[] args) {

        Book book = new Book("자바의 정석");
        Student lee = new Student("이영희");
        Teacher kim = new Teacher("김철수", "Java");

        Classroom classroom = new Classroom(book, lee, kim);

        classroom.startClass();
    }
}