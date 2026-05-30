public class Executive extends Regular {
    private long performancePay; // 성과수당
    private long stockOption;    // 스톡옵션

    public Executive(String id, String name, String birth, long basePay, long performancePay, long stockOption) {
        // 임원은 호봉(step)이 없으므로 0으로 세팅
        super(id, name, birth, "임원", 1, basePay, 0);

        // 요구사항: 한도 초과 방지 (입력 처리)
        this.performancePay = Math.min(performancePay, 7000000);
        this.stockOption = Math.min(stockOption, 10000000);
    }

    @Override
    public long calculatePayment() {
        return basePay + performancePay + stockOption;
    }

    @Override
    public void printRow() {
        // 성과수당을 수당1에, 스톡옵션을 수당2에 출력
        System.out.printf("%s\t%s(%s)\t%s\t-\t-\t-\t%,d\t%,d\t%,d\t%,d\t%,d\t%,d\n",
                empId, name, birth, position, basePay, performancePay, stockOption, calculateTax(), calculatePayment(), calculateNetPay());
    }
}