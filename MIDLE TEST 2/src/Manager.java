import java.time.LocalDate;

public class Manager extends RegularEmployee {

    public Manager(int employeeID, String name, LocalDate hireDate, int grade, int step) {
        super(employeeID, name, hireDate, grade, step);
    }

    @Override
    public long getStepAllowance() {
        return step * 150_000L;
    }

    @Override
    public long getManageAllowance() {
        // 기본급의 10%, 1000원 단위 절사
        long bonus = (long)(getBasicSalary() * 0.10);
        return (bonus / 1_000) * 1_000;
    }
}
