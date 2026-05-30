import java.time.LocalDate;
import java.util.*;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    // 회사에 직원 추가
    public void addEmployee(Employee e) {
        employees.add(e);
    }

    // 전체 급여 처리 및 리포트 출력
    public void processPayroll() {
        sortEmployees();
        printResult();
    }

    // 직급순 정렬 (정규직/연구원 1~8급 -> 일용직 -> 계약직 순)
    private void sortEmployees() {
        employees.sort((a, b) -> {
            int ka = sortKey(a), kb = sortKey(b);
            if (ka != kb) return Integer.compare(ka, kb);
            return Integer.compare(a.getEmployeeID(), b.getEmployeeID());
        });
    }

    // 정렬을 위한 키 값 (정규직은 1~8급, 일용직은 9, 계약직은 10)
    private int sortKey(Employee e) {
        int g = e.getGrade();
        if (g > 0) return g; // 1~8급
        if (e instanceof Temporary) return 9;
        if (e instanceof Contract)  return 10;
        return 11;
    }

    // 리포트 출력 로직
    private void printResult() {
        String line = "*".repeat(160);
        System.out.println(line);
        System.out.printf("%-6s %-5s %-20s %-12s %-6s %-4s %-10s %-13s %-10s %-10s %-10s %-10s %-14s %-12s %s%n",
                "사번", "이름", "생년월일", "직급", "호봉", "일수", "일급여",
                "기본급", "기본수당", "관리수당", "성과수당", "스톡옵션", "급여액", "세금", "지급액");
        System.out.println(line);

        for (Employee e : employees) {
            LocalDate d = e.getHireDate();
            String birth = String.format("(%d년%3d월%3d일)",
                    d.getYear(), d.getMonthValue(), d.getDayOfMonth());

            String gradeStr = e.getGrade() > 0
                    ? e.getGrade() + "급(" + e.getGradeName() + ")"
                    : "0급(" + e.getGradeName() + ")";

            String stepStr  = e.getStep() + "호봉";
            String daysStr  = String.valueOf(e.getWorkDays());
            String dailyStr = e.getDailyWage() > 0 ? fmt(e.getDailyWage()) + "원" : "0원";

            System.out.printf("%-6d %-5s %-22s %-13s %-7s %-5s %-10s %-14s %-11s %-11s %-11s %-11s %-16s %-14s %s%n",
                    e.getEmployeeID(), e.getName(), birth, gradeStr, stepStr, daysStr, dailyStr,
                    fmt(e.getBasicSalary())      + "원",
                    fmt(e.getStepAllowance())    + "원",
                    fmt(e.getManageAllowance())  + "원",
                    fmt(e.getPerformanceBonus()) + "원",
                    fmt(e.getStockOption())      + "원",
                    fmt(e.getPayment())          + "원",
                    fmt(e.getTax())              + "원",
                    fmt(e.getNetPay())           + "원"
            );
        }
        System.out.println(line);
    }

    private String fmt(long n) {
        return String.format("%,d", n);
    }
}