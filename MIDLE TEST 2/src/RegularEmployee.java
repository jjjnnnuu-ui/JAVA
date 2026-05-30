import java.time.LocalDate;

public abstract class RegularEmployee extends Employee {

    protected int grade; // 직급 (1~8)
    protected int step;  // 호봉 (1~7, 임원 제외)

    // 직급별 기본급 (index 8에 4,500,000원 추가)
    private static final long[] SALARY_BY_GRADE = {
            0,              // index 0 미사용
            6_000_000,      // 1: 상무
            5_000_000,      // 2: 이사
            4_589_000,      // 3: 부장
            3_689_000,      // 4: 차장
            3_235_000,      // 5: 과장
            2_589_000,      // 6: 대리
            2_123_000,      // 7: 사원
            4_500_000       // 8: 연구원 추가
    };

    // 직급명 배열 (마지막에 "연구" 추가)
    private static final String[] GRADE_NAME = {
            "", "상무", "이사", "부장", "차장", "과장", "대리", "사원", "연구"
    };

    public RegularEmployee(int employeeID, String name, LocalDate hireDate, int grade, int step) {
        super(employeeID, name, hireDate);
        this.grade = grade;
        this.step = step;
    }

    @Override
    public int getGrade() { return grade; }

    @Override
    public int getStep() { return step; }

    @Override
    public String getGradeName() { return GRADE_NAME[grade]; }

    @Override
    public long getBasicSalary() { return SALARY_BY_GRADE[grade]; }

    // 👇 아래가 제가 실수로 빼먹었던 원래 질문자님의 완벽한 코드들입니다. 복구했습니다! 👇
    @Override
    public long getPerformanceBonus() { return 0; }

    @Override
    public long getStockOption() { return 0; }

    @Override
    public long getDailyWage() { return 0; }

    @Override
    public int getWorkDays() { return 0; }

    @Override
    public String getTypeCode() { return "regular"; }
}