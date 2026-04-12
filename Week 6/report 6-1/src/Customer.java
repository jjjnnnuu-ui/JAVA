public class Customer extends Person implements BillCalculable {
    private int usageKw;
    private boolean isSupported;

    private long usageCost;
    private long tax;
    private long totalPayment;

    public Customer(String customerId, String name, int usageKw) {
        super(customerId, name);

        // 사용자 번호 유효성 검사
        if (customerId == null || !customerId.matches("\\d{5}")) {
            throw new IllegalArgumentException("사용자 번호는 5자리 숫자여야 합니다.");
        }

        // 사용량 유효성 검사
        if (usageKw < 0 || usageKw > 9999) {
            throw new IllegalArgumentException("사용량은 0 Kw 이상 9999 Kw 이하여야 합니다.");
        }

        this.usageKw = usageKw;
        this.isSupported = customerId.startsWith("9");

        // 객체 생성 시 자동 계산
        calculateBill();
    }

    @Override
    public void calculateBill() {
        ElectricBill.BillDetails details =
                ElectricBill.calculateTotalBill(this.usageKw, this.isSupported);

        this.usageCost = details.usageCost;
        this.tax = details.tax;
        this.totalPayment = details.totalPayment;
    }

    @Override
    public String getOtherInfo() {
        return isSupported ? "지원가구" : "";
    }

    @Override
    public void showInfo() {
        System.out.println("고객번호: " + customerId);
        System.out.println("이름: " + name);
        System.out.println("사용량: " + usageKw + "Kw");
    }

    public int getUsageKw() {
        return usageKw;
    }

    public boolean isSupported() {
        return isSupported;
    }

    public long getUsageCost() {
        return usageCost;
    }

    public long getTax() {
        return tax;
    }

    public long getTotalPayment() {
        return totalPayment;
    }

    @Override
    public String toString() {
        return String.format("%-6s %-6s %-8s %-10s %-8s %-10s %s",
                customerId,
                name,
                usageKw + "Kw",
                String.format("%,d원", usageCost),
                String.format("%,d원", tax),
                String.format("%,d원", totalPayment),
                getOtherInfo());
    }
}