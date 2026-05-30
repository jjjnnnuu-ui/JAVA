public class Contract extends Employee {
    private long monthlyPay;

    public Contract(String id, String name, String birth, long monthlyPay) {
        super(id, name, birth, "계약직", 4);
        this.monthlyPay = monthlyPay;
    }

    @Override
    public long calculatePayment() {
        return monthlyPay;
    }

    @Override
    public void printRow() {
        System.out.printf("%s\t%s(%s)\t%s\t-\t-\t-\t%,d\t0\t0\t%,d\t%,d\t%,d\n",
                empId, name, birth, position, monthlyPay, calculateTax(), calculatePayment(), calculateNetPay());
    }
}