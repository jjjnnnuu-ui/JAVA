import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        Employee[] employees = {
                new Employee("박정환", new Date(1996, 6, 18), 1422, '3', 4, 782000),
                new Employee("김대한", new Date(2003, 12, 4), 3456, '4', 5, 673000),
                new Employee("황정민", new Date(1996, 9, 20), 1456, '2', 4, 562000),
                new Employee("박대국", new Date(2000, 1, 7), 1789, '3', 2, 0),
                new Employee("이민국", new Date(1993, 6, 17), 5634, '5', 1, 569000),
                new Employee("홍길동", new Date(2001, 3, 20), 1112, '1', 1, 567000),
                new Employee("하충민", new Date(1994, 3, 16), 4521, '1', 1, 0),
                new Employee("길대연", new Date(1997, 4, 24), 1345, '2', 5, 451000),
                new Employee("나정산", new Date(2002, 8, 30), 1362, '3', 3, 458000),
                new Employee("이나라", new Date(1995, 5, 10), 1345, '5', 2, 342000)
        };

        // 박대국, 하충민 수당 입력
        employees[3].inputExtraPay(keyboard);
        employees[6].inputExtraPay(keyboard);

        System.out.println();
        System.out.println("■ 입력 결과");
        System.out.println();

        System.out.printf("%s님의 수당 입력 : %,d\n", employees[3].getName(), employees[3].getExtraPay());
        System.out.printf("%s님의 수당 입력 : %,d\n", employees[6].getName(), employees[6].getExtraPay());

        System.out.println("********************************************************************************************************");
        System.out.printf("%-18s %4s %-6s %2s %12s %10s %12s %10s %12s\n",
                "이름(생일)", "사번", "부서", "호봉", "본봉", "수당", "급여", "세금", "지급액");
        System.out.println("********************************************************************************************************");

        int totalBasePay = 0;
        int totalExtraPay = 0;
        int totalRealPay = 0;

        for (Employee e : employees) {
            e.print();
            totalBasePay += e.getBasePay();
            totalExtraPay += e.getExtraPay();
            totalRealPay += e.getRealPay();
        }

        System.out.println("********************************************************************************************************");
        System.out.printf("%45s %,10d %,10d %,20d\n", "합계", totalBasePay, totalExtraPay, totalRealPay);
        System.out.println("********************************************************************************************************");

        keyboard.close();
    }
}