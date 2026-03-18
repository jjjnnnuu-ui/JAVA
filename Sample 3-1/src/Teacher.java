public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void teach() {
        System.out.printf("%s 선생님(%s): 자, 수업하자!%n", subject, name);
    }
}