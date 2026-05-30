import java.time.LocalDate;

public abstract class Employee {
    protected int employeeID;
    protected String name;
    protected LocalDate hireDate;

    public Employee(int employeeID, String name, LocalDate hireDate) {
        this.employeeID = employeeID;
        this.name = name;
        this.hireDate = hireDate;
    }

    public int getEmployeeID() { return employeeID; }
    public String getName() { return name; }
    public LocalDate getHireDate() { return hireDate; }

    // 각 직종에서 구현
    public abstract long getBasicSalary();
    public abstract long getStepAllowance();
    public abstract long getManageAllowance();
    public abstract long getPerformanceBonus();
    public abstract long getStockOption();
    public abstract long getDailyWage();
    public abstract int getWorkDays();
    public abstract int getGrade();
    public abstract String getGradeName();
    public abstract int getStep();
    public abstract String getTypeCode(); // 직종 코드 (정렬용)

    public long getPayment() {
        return getBasicSalary() + getStepAllowance() + getManageAllowance()
                + getPerformanceBonus() + getStockOption();
    }

    public long getTax() {
        long payment = getPayment();
        double rate;
        if (payment < 2_000_000) {
            rate = 0.045;
        } else if (payment < 4_000_000) {
            rate = 0.084;
        } else if (payment < 6_000_000) {
            rate = 0.106;
        } else {
            rate = 0.123;
        }
        return Math.round(payment * rate);
    }

    public long getNetPay() {
        return getPayment() - getTax();
    }
}
