import java.time.LocalDate;

public class Staff extends RegularEmployee {

    public Staff(int employeeID, String name, LocalDate hireDate, int grade, int step) {
        super(employeeID, name, hireDate, grade, step);
    }

    @Override
    public long getStepAllowance() {
        return step * 100_000L;
    }

    @Override
    public long getManageAllowance() {
        return 0;
    }
}
