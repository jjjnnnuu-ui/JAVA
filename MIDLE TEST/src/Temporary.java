public class Temporary extends Employee {
    private int days;
    private long dailyPay;

    public Temporary(String id, String name, String birth, int days, long dailyPay) {
        super(id, name, birth, "일용직", 5);
        this.days = days;
        this.dailyPay = dailyPay;
    }

    @Override
    public long calculatePayment() {
        return days * dailyPay;
    }

    @Override
    public void printRow() {
        System.out.printf("%s\t%s(%s)\t%s\t%d\t-\t%,d\t0\t0\t0\t%,d\t%,d\t%,d\n",
                empId, name, birth, position, days, dailyPay, calculateTax(), calculatePayment(), calculateNetPay());
    }
}