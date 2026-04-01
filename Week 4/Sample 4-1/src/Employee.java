import java.util.Scanner;

public class Employee {
    private String name;
    private Date birthDay;
    private int empNo;          // 사번
    private char departNo;      // 부서번호
    private int grade;          // 호봉
    private int extraPay;       // 수당

    public Employee(String name, Date birthDay, int empNo, char departNo, int grade, int extraPay) {
        this.name = name;
        this.birthDay = birthDay;
        this.empNo = empNo;
        this.departNo = departNo;
        this.grade = grade;
        this.extraPay = extraPay;
    }

    public String getName() {
        return name;
    }

    public int getEmpNo() {
        return empNo;
    }

    public int getGrade() {
        return grade;
    }

    public int getExtraPay() {
        return extraPay;
    }

    public int getBasePay() {
        switch (grade) {
            case 1: return 1650000;
            case 2: return 1680000;
            case 3: return 1700000;
            case 4: return 1720000;
            case 5: return 1750000;
            default: return 0;
        }
    }

    public String getDepartName() {
        switch (departNo) {
            case '1': return "인사부";
            case '2': return "기획부";
            case '3': return "개발부";
            case '4': return "영업부";
            case '5': return "생산부";
            default: return "기타부";
        }
    }

    public int getSalary() {
        return getBasePay() + extraPay;
    }


    public int getTax() {
        return (int)(getSalary() * 0.1);
    }

    public int getRealPay() {
        return getSalary() - getTax();
    }

    public void inputExtraPay(Scanner keyboard) {
        while (true) {
            System.out.printf("%s님의 수당 입력 : ", name);
            extraPay = keyboard.nextInt();

            if (extraPay >= 0 && extraPay <= 1000000) {
                break;
            } else {
                System.out.println("오류 : 수당은 0 ~ 1000000 사이만 입력하세요.");
            }
        }
    }

    public void print() {
        System.out.printf("%-18s %4d %-6s %2d %,10d원 %,9d원 %,10d원 %,9d원 %,10d원\n",
                name + "(" + birthDay + ")",
                empNo,
                getDepartName(),
                grade,
                getBasePay(),
                extraPay,
                getSalary(),
                getTax(),
                getRealPay());
    }
}




