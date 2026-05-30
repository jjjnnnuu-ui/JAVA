import java.time.LocalDate;

public class Temporary extends Employee {

    private long dailyWage;
    private int workDays;

    public Temporary(int employeeID, String name, LocalDate hireDate,
                     long dailyWage, int workDays) {
        super(employeeID, name, hireDate);
        this.dailyWage = dailyWage;
        this.workDays = workDays;
    }

    @Override
    public long getBasicSalary() { return dailyWage * workDays; }

    @Override
    public long getStepAllowance() { return 0; }

    @Override
    public long getManageAllowance() { return 0; }

    @Override
    public long getPerformanceBonus() { return 0; }

    @Override
    public long getStockOption() { return 0; }

    @Override
    public long getDailyWage() { return dailyWage; }

    @Override
    public int getWorkDays() { return workDays; }

    @Override
    public int getGrade() { return 0; }

    @Override
    public String getGradeName() { return "일용"; }

    @Override
    public int getStep() { return 0; }

    @Override
    public String getTypeCode() { return "temporary"; }
}
