public class Classroom {
    private Book book;
    private Student student;
    private Teacher teacher;

    public Classroom(Book book, Student student, Teacher teacher) {
        this.book = book;
        this.student = student;
        this.teacher = teacher;
    }

    public void startClass() {
        teacher.teach();
        student.study(book);
    }
}