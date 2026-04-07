public class Customer {
    private String customerId; // 사용자 번호 (5자리 숫자 코드)
    private String name;       // 이름
    private int usageKw;       // 전기 사용량 (Kw)
    private boolean isSupported; // 지원 가구 여부

    private long usageCost;      // 사용 요금 (기본 요금 + 사용량 * Kw당 사용 요금)
    private long tax;            // 세금
    private long totalPayment;   // 납부 요금 (사용 요금 + 세금)

    public Customer(String customerId, String name, int usageKw) {
        // 사용자 번호 유효성 검사 (5자리 숫자)
        if (customerId == null || !customerId.matches("\\d{5}")) {
            throw new IllegalArgumentException("사용자 번호는 5자리 숫자여야 합니다.");
        }
        // 사용량 유효성 검사 (최대 9999 Kw)
        if (usageKw < 0 || usageKw > 9999) {
            throw new IllegalArgumentException("사용량은 0 Kw 이상 9999 Kw 이하여야 합니다.");
        }

        this.customerId = customerId;
        this.name = name;
        this.usageKw = usageKw;
        // 사용자 번호가 '9'로 시작하면 지원 가구
        this.isSupported = customerId.startsWith("9");

        // 초기 계산 (객체 생성 시 바로 계산)
        calculateBill();
    }

    private void calculateBill() {
        ElectricBill.BillDetails details = ElectricBill.calculateTotalBill(this.usageKw, this.isSupported);
        this.usageCost = details.usageCost;
        this.tax = details.tax;
        this.totalPayment = details.totalPayment;

        // Kw당 사용 요금 계산 로직을 ElectricBill 클래스로 이동
        // ElectricBill.calculateUsageCharge(this.usageKw, this.isSupported)는 내부 로직
    }

    // Getter methods
    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
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

    // 기타 정보 출력 (지원 가구 여부 등)
    public String getOtherInfo() {
        return isSupported ? "지원가구" : "";
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
