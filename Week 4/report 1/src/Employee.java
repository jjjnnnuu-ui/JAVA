public class Employee {
    private int id;
    private String name;
    private int part;
    private boolean special;
    private int grade;
    private int ho;
    private int aid;

    public Employee(int id, String name, int part, boolean special, int grade, int ho, int aid) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.special = special;
        this.grade = grade;
        this.ho = ho;
        this.aid = aid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPart() {
        return part;
    }

    public boolean isSpecial() {
        return special;
    }

    public int getGrade() {
        return grade;
    }

    public int getHo() {
        return ho;
    }

    public int getAid() {
        return aid;
    }
}