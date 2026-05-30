public abstract class Employee implements Comparable<Employee> {
    protected String empId, name, birth;
    protected String position;
    protected int rankWeight; // 정렬용: 임원(1), 관리직(2), 정규직(3), 계약직(4), 일용직(5)

    public Employee(String empId, String name, String birth, String position, int rankWeight) {
        this.empId = empId; this.name = name; this.birth = birth;
        this.position = position; this.rankWeight = rankWeight;
    }

    // 자식 클래스에서 구현할 급여액(기본급 + 각종 수당)
    public abstract long calculatePayment();

    // 요구사항: 급여액 기준 구간별 세율 적용
    public long calculateTax() {
        long payment = calculatePayment();
        double rate;
        if (payment < 2000000) {
            rate = 0.045;
        } else if (payment < 4000000) {
            rate = 0.084;
        } else if (payment < 6000000) {
            rate = 0.106;
        } else {
            rate = 0.123;
        }
        return (long)(payment * rate);
    }

    // 실수령액 = 급여액 - 세금
    public long calculateNetPay() {
        return calculatePayment() - calculateTax();
    }

    // 요구사항: 직급순(올림차순) 정렬
    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.rankWeight, o.rankWeight);
    }

    public abstract void printRow();
}