import java.time.LocalDate;

public class Executive extends RegularEmployee {

    private long performanceBonus;
    private long stockOption;

    public Executive(int employeeID, String name, LocalDate hireDate, int grade,
                     long performanceBonus, long stockOption) {
        super(employeeID, name, hireDate, grade, 0); // 임원은 호봉 없음
        this.performanceBonus = performanceBonus;
        this.stockOption = stockOption;
    }

    @Override
    public long getStepAllowance() { return 0; }

    @Override
    public long getManageAllowance() { return 0; }

    @Override
    public long getPerformanceBonus() { return performanceBonus; }

    @Override
    public long getStockOption() { return stockOption; }
}
