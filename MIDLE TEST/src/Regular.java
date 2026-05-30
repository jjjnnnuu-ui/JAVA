public class Regular extends Employee {
    protected long basePay;
    protected int step; // 호봉

    public Regular(String id, String name, String birth, String pos, int weight, long basePay, int step) {
        super(id, name, birth, pos, weight);
        this.basePay = basePay;
        this.step = step;
    }

    // 요구사항: 정규직 호봉당 10만, 관리직 호봉당 15만 (임원은 0)
    public long getStepPay() {
        if (position.equals("임원")) return 0;
        int rate = position.equals("관리직") ? 150000 : 100000;
        return (long)step * rate;
    }

    // 요구사항: 관리직만 기본급 10% 추가, 1,000원 단위 절사
    public long getManagerBonus() {
        if (!position.equals("관리직")) return 0;
        long bonus = (long)(basePay * 0.1);
        return (bonus / 1000) * 1000; // 1,000원 단위 절사 로직
    }

    @Override
    public long calculatePayment() {
        return basePay + getStepPay() + getManagerBonus();
    }

    @Override
    public void printRow() {
        // 호봉수당을 수당1에, 관리수당을 수당2에 출력
        System.out.printf("%s\t%s(%s)\t%s\t-\t%d\t-\t%,d\t%,d\t%,d\t%,d\t%,d\t%,d\n",
                empId, name, birth, position, step, basePay, getStepPay(), getManagerBonus(), calculateTax(), calculatePayment(), calculateNetPay());
    }
}