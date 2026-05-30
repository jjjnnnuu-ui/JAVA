import java.time.LocalDate;

public class Contract extends Employee {

    private static final long FIXED_SALARY = 2_000_000;

    public Contract(int employeeID, String name, LocalDate hireDate) {
        super(employeeID, name, hireDate);
    }

    @Override
    public long getBasicSalary() { return FIXED_SALARY; }

    @Override
    public long getStepAllowance() { return 0; }

    @Override
    public long getManageAllowance() { return 0; }

    @Override
    public long getPerformanceBonus() { return 0; }

    @Override
    public long getStockOption() { return 0; }

    @Override
    public long getDailyWage() { return 0; }

    @Override
    public int getWorkDays() { return 0; }

    @Override
    public int getGrade() { return 0; }

    @Override
    public String getGradeName() { return "계약"; }

    @Override
    public int getStep() { return 0; }

    @Override
    public String getTypeCode() { return "contract"; }
}
