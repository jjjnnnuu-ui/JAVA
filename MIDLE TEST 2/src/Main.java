import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Company myCompany = new Company();

        // ── 일용직 입력 ──────────────────────────
        long[] gyeong = inputTemporary("경복대");
        myCompany.addEmployee(new Temporary(2004, "경복대", LocalDate.of(2000, 3, 24), gyeong[0], (int) gyeong[1]));

        // ── 임원 입력 ──────────────────────────
        long[] lee = inputExecutive("이영희");
        myCompany.addEmployee(new Executive(3001, "이영희", LocalDate.of(1975, 7, 7), 1, lee[0], lee[1]));

        long[] shin = inputExecutive("신동진");
        myCompany.addEmployee(new Executive(3401, "신동진", LocalDate.of(1977, 10, 7), 2, shin[0], shin[1]));

        long[] ryu = inputTemporary("류동규");
        myCompany.addEmployee(new Temporary(4562, "류동규", LocalDate.of(2000, 10, 14), ryu[0], (int) ryu[1]));

        // ── 정규직 & 연구원 & 계약직 ────────────────
        myCompany.addEmployee(new Manager(2001, "김철수", LocalDate.of(1985, 5, 5), 3, 5));
        myCompany.addEmployee(new Manager(2041, "진성철", LocalDate.of(1996, 11, 5), 4, 4));
        myCompany.addEmployee(new Staff(1401, "박동철", LocalDate.of(1994, 8, 20), 5, 5));
        myCompany.addEmployee(new Staff(1001, "홍길동", LocalDate.of(1990, 1, 1), 7, 3));
        myCompany.addEmployee(new Researcher(5001, "이진우", LocalDate.of(1992, 4, 15), 3));
        myCompany.addEmployee(new Contract(5678, "이대한", LocalDate.of(1990, 3, 24)));
        myCompany.addEmployee(new Contract(5588, "정영진", LocalDate.of(1978, 12, 20)));

        // ── 결과 출력 실행 ──
        myCompany.processPayroll();
    }

    static long[] inputExecutive(String name) {
        long perf, stock;
        while (true) {
            System.out.printf("[임원] %s님의 성과 수당 입력 : ", name);
            perf = sc.nextLong();
            if (perf <= 7_000_000) break;
            System.out.println("ERROR : 7,000,000원을 초과하지 않음");
        }
        while (true) {
            System.out.printf("[임원] %s님의 스톡옵션 입력 : ", name);
            stock = sc.nextLong();
            if (stock <= 10_000_000) break;
            System.out.println("ERROR : 10,000,000원을 초과하지 않음");
        }
        return new long[]{perf, stock};
    }

    static long[] inputTemporary(String name) {
        long daily; int days;
        while (true) {
            System.out.printf("[일용직] %s님의 일당 입력 : ", name);
            daily = sc.nextLong();
            if (daily >= 25_000 && daily <= 95_000) break;
            System.out.println("ERROR : 25,000 ~ 95,000 사이의 금액을 입력하세요");
        }
        System.out.printf("[일용직] %s님의 작업 일수 입력 : ", name);
        days = sc.nextInt();
        return new long[]{daily, days};
    }
}