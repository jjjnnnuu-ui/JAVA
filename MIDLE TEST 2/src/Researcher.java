import java.time.LocalDate;

public class Researcher extends RegularEmployee {

    // 연구원은 직급이 무조건 8급이므로 부모(super)에게 8을 고정으로 넘깁니다.
    public Researcher(int employeeID, String name, LocalDate hireDate, int step) {
        super(employeeID, name, hireDate, 8, step);
    }

    @Override
    public long getStepAllowance() {
        return step * 100_000L; // 호봉당 10만원
    }

    @Override
    public long getManageAllowance() {
        // 연구수당: 기본급의 30% 지급
        return (long)(getBasicSalary() * 0.30);
    }

    // ⭐ [핵심] 비과세 처리: Employee의 getTax()를 오버라이딩하여 연구수당을 세금 계산에서 뺍니다.
    @Override
    public long getTax() {
        // 과세 대상 금액 = 총 지급액(getPayment) - 연구수당(getManageAllowance)
        long taxablePayment = getPayment() - getManageAllowance();

        double rate;
        if (taxablePayment < 2_000_000) {
            rate = 0.045;
        } else if (taxablePayment < 4_000_000) {
            rate = 0.084;
        } else if (taxablePayment < 6_000_000) {
            rate = 0.106;
        } else {
            rate = 0.123;
        }
        return (long)(taxablePayment * rate);
    }
}