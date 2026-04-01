public class Main {
    public static void main(String[] args) {

        Input input = new Input();
        Compute compute = new Compute();
        Output output = new Output();

        Employee e = input.inputEmployee();

        int base = compute.getBasePay(e.getGrade(), e.getHo());
        int partPay = compute.getPartPay(e.getPart());
        int gradePay = compute.getGradePay(e.getGrade());

        int totalPay = base + partPay + gradePay;

        int tax = compute.getTax(totalPay, e.isSpecial(), base);

        int finalPay = totalPay - tax - e.getAid();

        output.print(e, base, partPay, gradePay, tax, finalPay);
    }
}