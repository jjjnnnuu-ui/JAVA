import java.util.Scanner;

public class Input {
    public Employee inputEmployee() {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("사번: ");
        int id = keyboard.nextInt();

        System.out.print("이름: ");
        String name = keyboard.next();

        System.out.print("부서코드: ");
        int part = keyboard.nextInt();

        System.out.print("보훈(true/false): ");
        boolean special = keyboard.nextBoolean();

        System.out.print("직급: ");
        int grade = keyboard.nextInt();

        System.out.print("호봉: ");
        int ho = keyboard.nextInt();

        System.out.print("개인공제: ");
        int aid = keyboard.nextInt();

        return new Employee(id, name, part, special, grade, ho, aid);
    }
}